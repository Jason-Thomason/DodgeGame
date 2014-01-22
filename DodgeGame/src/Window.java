import java.awt.FlowLayout;

import javax.swing.JFrame;


public class Window extends JFrame{

	public static int width = 400, height = 400;
	HandlerClass inputHandler = new HandlerClass();
	
	public Window(){
		
		super("Dodge Game");
		setup();
		
	}
	
	public void setup(){
		
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.addKeyListener(inputHandler);
		
	}
	
}
