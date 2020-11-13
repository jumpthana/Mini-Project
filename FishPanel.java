
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.*;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import sun.audio.*;
import java.io.*;

public class FishPanel extends JPanel{
	
	private ImageIcon bg,fish,over,bar;
	private int t=1,x,y,xkey;
	private int score=0;
	private int dead=0;
	private int safe=0;
	private int[] enemyX = {82,120,169,200,231,308};
	
	private Random ran = new Random();
	int Xpos = ran.nextInt(6);
	int time = ran.nextInt(10);
	int y1 = 50;
	int xbar=230;
	int xxx,de=0;
	
	static AudioStream seal,p;
	
	Timer timer = new Timer(5, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			y1=y1+1;
			t++;
			repaint();
			check();
		}
	});

    public void addHand(int x,int y) {
    	this.x=x;
    	this.y=y;
    }
    
    public void addKey(int xkey) {
    	this.xbar = xbar+xkey;
    	//System.out.println(xbar);
    }
    
    public void check() {
    	if(y1+10==y) {
    		//System.out.println(y);
    		score=score+10;
    		//System.out.println(score);
    		safe=safe+1;
    		soundPoint();
    	}
    	if(y1+50==380) {
    		soundDead();
    		dead=dead+1;
    	}
    }
    public void soundPoint() {
    	try {
	         InputStream in = new FileInputStream("Super Mario Bros Coin Sound Effec.wav");
	         p = new AudioStream(in);
	         AudioPlayer.player.start(p);
	      } catch (IOException e) {

	      }
    }
    
    public void soundDead() {
    	try {
	         InputStream in = new FileInputStream("Seal Call Zoo.wav");
	         seal = new AudioStream(in);
	         AudioPlayer.player.start(seal);
	      } catch (IOException e) {

	      }
    }


	public void paint(Graphics g) {
		bg = new ImageIcon("BGGame2.gif");
		bg.paintIcon(this, g, 0, 0);
		if(dead<3) {
			if(xbar>=40 && xbar<=400) {
			bar = new ImageIcon("Bar.png");
			bar.paintIcon(this, g, xbar, 350);
			}
			else if(xbar>=400){
				bar.paintIcon(this, g, 400, 350);
				xbar=400;
			}
			else if(xbar<=40){
				bar.paintIcon(this, g, 40, 350);
				xbar=40;
			}
			if(t==0) {
				Xpos = ran.nextInt(6);
				y1 = 50;
				fish = new ImageIcon("Fish3.png");
				fish.paintIcon(this, g, enemyX[Xpos], y1);
				timer.start();
			}
			if(t>=3) {
				if(y1+10 != y) {
					fish = new ImageIcon("Fish3.png");
					fish.paintIcon(this, g, enemyX[Xpos], y1);
				}
				else {
					x=0;
					y=0;
					fish = new ImageIcon("");
					fish.paintIcon(this, g, 1000, 1000);
					t=0;
					timer.stop();
				}

			}
			if(enemyX[Xpos] >= xbar-30 && enemyX[Xpos] <= xbar+50 && y1+85 == 350) {
				score=score+10;
	    		safe=safe+1;
	    		soundPoint();
	    		de=1;
			}
			if(y1+50==380||de==1) {
				de=0;
				x=0;
				y=0;
				fish = new ImageIcon("");
				fish.paintIcon(this, g, 1000, 1000);
				t=0;
				timer.stop();
			}
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial",Font.PLAIN,25));
			g.drawString(""+dead, 200, 580);
			g.drawString(""+safe, 500, 580);
			g.drawString(""+score, 750, 580);
		}
		else {
			
				timer.stop();
				over = new ImageIcon("BGOver.png");
				over.paintIcon(this, g, 0, 0);
				g.setColor(Color.BLACK);
				g.setFont(new Font("arial",Font.PLAIN,75));
				g.drawString("SCORE: "+score, 200, 325);
					
		}
	}
	
	
	
	
	
	
	
	
	
	
}
