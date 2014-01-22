
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


public class Enemy {
	//Initializes each instance of enemy and sets spawn coordinates randomly
	private boolean spawned = false;
	Random rand = new Random();
	private double x,  y , xDirection, yDirection;
	
	public Enemy(){
		if(spawned == false){
			while(Math.sqrt((x-200)*(x-200) + (y-200)*(y-200))<=300){
			x = rand.nextInt(500)-50;
			y = rand.nextInt(500)-50;
		}
				if(Math.sqrt((x-200)*(x-200) + (y-200)*(y-200))>=300){
					xDirection = (Player.x-this.x)/400;
					yDirection = (Player.y-this.y)/400;
					spawned = true;
			}
		}
	}
	
	public void tick(){
		move();
	}
	
	public void render(Graphics g){
		if(spawned == true){
			g.setColor(Color.RED);
			g.fillRect((int)Math.round(x), (int)Math.round(y), 10, 10);
		}
	}
	
	//Updates enemy positions
		public void move(){	
				this.x += this.xDirection;
				this.y += this.yDirection;
				if(Math.sqrt((x-200)*(x-200) + (y-200)*(y-200))>=300){
					spawned = false;
				}
				
			}
		
		
		
		public double getx(){
			return x;
		}
		
		public double gety(){
			return y;
		}
		
		public boolean getspawned(){
			return spawned;
		}
		
		public void setspawned(boolean spawned){
			this.spawned = spawned;
		}
	
	
}
