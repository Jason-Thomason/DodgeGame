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
				tick();
				render(g);
				
				Thread.sleep(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
}

