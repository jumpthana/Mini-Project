
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener{
	private FishPanel fi2;
	
	public Key(FishPanel fi2) {
		this.fi2=fi2;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Key Pressed: " + e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			fi2.addKey(-20);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			fi2.addKey(20);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Released: " + e.getKeyChar());
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Typed: " + e.getKeyChar());
		
	}
}
