import java.awt.Graphics;
import java.util.ArrayList;


public class World {

	Player player1 = new Player();
	Background background = new Background();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	public World(){
		enemies.add(new Enemy());
	}
	
	public void tick(){
		player1.tick();
		background.tick();
		for(int i=0; i<enemies.size(); i++){
			
			enemies.get(i).tick();
			if(enemies.get(i).getspawned() == false){
				enemies.remove(i);
			}
		}
		//Keeps enemy count higher as time goes on
				if(enemies.size() <= ClayJason.timer/1000){
					enemies.add(new Enemy());
			}
		checkCollisions();
	}
	
	public void render(Graphics g){
		background.render(g);
		player1.render(g);
		for(Enemy e: enemies){
			e.render(g);
		}
	}
	
	public void checkCollisions(){
		//Collision detection
		for(Enemy e : enemies){
			if(e.getx() >= player1.x - 10 && e.getx() <= player1.x + 20 && e.gety() >= player1.y - 20 && e.gety() <= player1.y + 10 && e.getspawned() == true){
				e.setspawned(false);
				
				ClayJason.timer -= ClayJason.timer/8;
			}
		}
	}
	
}
