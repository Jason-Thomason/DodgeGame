import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Player {

	public static int x, y, speed=1;
	
	HandlerClass HandlerClass = new HandlerClass();
	
	
	public Player(){
		x = 200;
		y = 200;
	}
	
	public void tick(){
		move();
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 20, 20);
	}
	
	public void move(){
		// Update position
			checkKeys();	
				// Basic Collision Detection with borders of 400X400 window. It will need a buffer zone for better looks
				if(x <= 3){
					x = 3;
				}
				if(x >= 375){
					x = 375;
				}
				if(y <= 25){
					y = 25;
				}
				if(y >= 375){
					y = 375;
				}
	}
	
	public void checkKeys(){
		if(HandlerClass.getdownPressed()){
			y += speed;
		}
		if(HandlerClass.getupPressed()){
			y -= speed;
		}
		if(HandlerClass.getleftPressed()){
			x -= speed;
		}
		if(HandlerClass.getrightPressed()){
			x += speed;
		}
	}
}
