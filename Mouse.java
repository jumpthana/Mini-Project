
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.VoiceStatus;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Mouse extends MouseAdapter{
	private FishPanel fi;
	private int x,y;
	static AudioStream as;
	
	public Mouse(FishPanel fi) {
		super();
		this.fi=fi;
	}
	
	public void startClick() {
		try {
	         InputStream in = new FileInputStream("Click.wav");
	         as = new AudioStream(in);
	         AudioPlayer.player.start(as);	         
	      } catch (IOException e) {

	      }
	}
	
@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		fi.addHand(e.getX(),e.getY());
		startClick();
		System.out.println(e.getX()+" "+e.getY());
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}