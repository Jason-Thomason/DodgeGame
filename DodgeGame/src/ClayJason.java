import java.awt.*;
import java.awt.image.VolatileImage;

import javax.swing.*;

import java.util.*;

public class ClayJason implements Runnable{

	World world = new World();
	Window window = new Window();
	
	VolatileImage image;
	Graphics g;
	
	public static int timer = 0, highScore=0;
	
	private int loops;
	private static int FPS = 60, MAX_FRAME_SKIP = 2, SKIP_TICKS = 1000/FPS;
	private long CURRENT_TIME = System.currentTimeMillis();
	
	
	public static void main (String[] args){
		System.out.println("Main");
		new ClayJason();	
	}
	
	public ClayJason(){
		Thread thread = new Thread(this);
		thread.start();
	}

	
	public void tick(){
		timer++;
		world.tick();
	}
	
	public void render(Graphics g){
		world.render(g);
		
		g = window.getGraphics();
		g.drawImage(image, 0, 0, null);
	}
	
	public void run() {
		System.out.println("Run Start");
		image = window.createVolatileImage(Window.width, Window.height);
		g = image.getGraphics();
		
		try{
			while(true) {
				
				loops = 0;
				//Calculate data as long as we are behind schedule and we havn't skipped display too much
				while(System.currentTimeMillis() > CURRENT_TIME && loops < MAX_FRAME_SKIP){
					tick();
					
					CURRENT_TIME += SKIP_TICKS;
					loops++;
				}
				render(g);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
}

