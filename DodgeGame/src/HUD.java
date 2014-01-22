import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	private int score = 0, highScore = 0;
	Font font = new Font("Arial", Font.BOLD, 15);
	
	public void tick(){
		score = ClayJason.timer/10;
		if(score > highScore)
			highScore = score;
	}
	
	public void render(Graphics g){
		g.setFont(font);
		g.setColor(Color.yellow);
		g.drawString("SCORE: " + score, 15, 40);
		g.drawString("HIGHSCORE: " + highScore, 15, 60);
	}
	
}
