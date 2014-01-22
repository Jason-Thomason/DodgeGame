import java.awt.Color;
import java.awt.Graphics;


public class Background {
private int rColor = 0, gColor = 0, bColor = 0;
	
	public Background(){
		
	}
	
	
	
	public void tick(){
		updateColor();
	}
	
	public void render(Graphics g){
		g.setColor(new Color(rColor, gColor, bColor));
		g.fillRect(0, 0, Window.width, Window.height);
	}
	
	public void updateColor(){
		double midValue = 255 / 2;
		rColor = (int) (Math.cos(Math.toRadians(ClayJason.timer/15)) * midValue + midValue + 0.5);
		gColor = (int) (Math.cos(Math.toRadians(ClayJason.timer/20)) * midValue + midValue + 0.5);
		bColor = (int) (Math.cos(Math.toRadians(ClayJason.timer/25)) * midValue + midValue + 0.5);
	}
}
