import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class HandlerClass implements KeyListener{

	private static boolean leftPressed = false, rightPressed = false, upPressed = false, downPressed = false;
	
	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_LEFT){
			leftPressed = true;
		}	
		if(event.getKeyCode() == KeyEvent.VK_RIGHT){
			rightPressed = true;
		}
		if(event.getKeyCode() == KeyEvent.VK_UP){
			upPressed = true;
		}
		if(event.getKeyCode() == KeyEvent.VK_DOWN){
			downPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_LEFT){
			leftPressed = false;
		}	
		if(event.getKeyCode() == KeyEvent.VK_RIGHT){
			rightPressed = false;
		}
		if(event.getKeyCode() == KeyEvent.VK_UP){
			upPressed = false;
		}
		if(event.getKeyCode() == KeyEvent.VK_DOWN){
			downPressed = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getleftPressed(){
		return leftPressed;
	}
	
	public boolean getrightPressed(){
		return rightPressed;
	}
	
	public boolean getupPressed(){
		return upPressed;
	}
	
	public boolean getdownPressed(){
		return downPressed;
	}

}
