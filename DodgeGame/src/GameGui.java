
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameGui extends JFrame implements Runnable{

	/*
	 * 					TODO List
	 *  1. Add lives 
	 *  2. Add different screens such as menu and death
	 *  3. Make background more interesting (Slow color changing would be cool. Use int's for RGB?
	 *  4. Add power-ups
	 *  5. There's so many possibilities
	 *  6. I'm excited
	 *  
	 */
	
	int x, y, xDirection, yDirection;
	Font font = new Font("Ariel", Font.BOLD, 15);
	private Image dbImage;
	private Graphics dbg;
	Random rand = new Random();
	private int timer = 0;
	private int collisions = 0;
	private int highScore = 0;
	ArrayList<Enemy> AL = new ArrayList<Enemy>();
	
	public void move(){

		// Update position
		x += xDirection;
		y += yDirection;
		
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

	//Updates enemy positions
	public void eMove(){	
		for(Enemy e : AL){
			e.x += e.xDirection;
			e.y += e.yDirection;
			if(timer/10 > highScore){
				highScore = timer/10; 
			}
		}
			//Keeps enemy count higher as time goes on
			if(AL.size() <= timer/1000){
				AL.add(new Enemy());
		}
			//Collision detection
			for(Enemy e : AL){
				if(e.x >= this.x - 10 && e.x <= this.x + 20 && e.y >= this.y - 20 && e.y <= this.y + 10){
					e.spawned = false;
					collisions++;
					System.out.println("Collision " + collisions);
					
					timer -= timer/8;
				}
			}
	}
	// Separate methods for changing the value of xDirection and yDirection
	public void setxDirection(int xdir){
		xDirection = xdir;
	}
	
	public void setyDirection(int ydir){
		yDirection = ydir;
	}
	
	// HandlerClass for key inputs
	public class HandlerClass extends KeyAdapter{
		public void keyPressed(KeyEvent event) {
			if(event.getKeyCode() == event.VK_LEFT){
				setxDirection(-1);
				}	
			if(event.getKeyCode() == event.VK_RIGHT){
				setxDirection(1);
			}
			if(event.getKeyCode() == KeyEvent.VK_UP){
				setyDirection(-1);
			}
			if(event.getKeyCode() == KeyEvent.VK_DOWN){
				setyDirection(1);
			}
		}
		public void keyReleased(KeyEvent event) {
			if(event.getKeyCode() == event.VK_LEFT){
				setxDirection(0);
			}	
			if(event.getKeyCode() == event.VK_RIGHT){	
				setxDirection(0);
			}
			if(event.getKeyCode() == KeyEvent.VK_UP){
				setyDirection(0);				
			}
			if(event.getKeyCode() == KeyEvent.VK_DOWN){
				setyDirection(0);
				}
		}
		public void keyTyped(KeyEvent event) {			
		}
		
	}
	// Main Constructor for when the object is created in another Class
	public GameGui(){
		super("Title");
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setBackground(Color.white);
		setResizable(false);
		setVisible(true);
		addKeyListener(new HandlerClass());
		AL.add(new Enemy());

		x = 200;
		y = 200;
		run();
		
		
	}
	// I think this just takes an image of the screen, analyzes it, and paints over previous images. Its double buffering.
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	// This will draw our stuffs for us
	public void paintComponent (Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(x, y, 20, 20);
		g.setFont(font);
		g.drawString("SCORE: " + timer/10, 5, 40);
		g.drawString("HIGHSCORE: " + highScore, 5, 60);
		
		
		
			for(int i = 0; i < AL.size(); i++){
				if(AL.size() > 0){
				Enemy e = AL.get(i);
				g.setColor(Color.red);
				if (e.spawned == false){
					e.x = rand.nextInt(500) - 50;
					e.y = rand.nextInt(500) - 50;
						if(Math.sqrt((e.x - this.x)*(e.x - this.x) + (e.y - this.y)*(e.y - this.y)) >= 300){
							g.fillRect((int)Math.round(e.x), (int)Math.round(e.y), 10, 10);
							e.xDirection = (this.x - e.x )/400;
							e.yDirection = (this.y - e.y)/400;
							e.spawned = true;
						}
				}else if(e.spawned == true){
					g.fillRect((int)Math.round(e.x), (int)Math.round(e.y), 10, 10);
					if(Math.sqrt((e.x - this.x)*(e.x - this.x) + (e.y - this.y)*(e.y - this.y)) >= 400){
						if(AL.size() > 0){
						AL.remove(e);
					}
				}
			}
			}
		}repaint();
	}

	// Main run method
	public void run() {
		System.out.println("Running");
		try{
			while(true){
				move();
				eMove();
				
				timer++;
				Thread.sleep(3);
			}
		}
		catch(Exception e){
			System.out.println("Error in run");
			// Not sure how to make it print what the error actually is
		}
		
	}
	
	
	
	
	
	
	
	
	
}
