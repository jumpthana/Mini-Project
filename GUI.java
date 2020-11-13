
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.Event.*;

import sun.audio.*;
import java.util.*;

public class GUI extends JFrame {
	
	int m,x,y;
	/**
	 * Launch the application.
	 */
	static AudioStream as,as2;
	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.setTitle("Gold Fish");
		frame.setBounds(100, 100, 911, 681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}
	/**
	 * Create the application.
	 */
	public GUI() {
		//initialize();
		
		try {
	         InputStream in = new FileInputStream("Happyrock.wav"); 
	         InputStream in2 = new FileInputStream("Star Wars Cantina Band.wav");
	         as = new AudioStream(in);
	         as2 = new AudioStream(in2);
	         AudioPlayer.player.start(as);
	      } catch (IOException e) {
	    	  
	      }
		//start
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 893, 633);
		panel.setVisible(true);
		add(panel);
		panel.setLayout(null);
		//end
		FishPanel f = new FishPanel();
		f.setBounds(0, 0, 893, 633);
		f.setVisible(false);
		add(f);
		f.setLayout(null);
		f.addKeyListener(new Key(f));
		f.addMouseListener(new Mouse(f));
		
		JTextField field = new JTextField(20);
		field.addKeyListener(new Key(f));
		add(field);
		
		JButton Startbutton = new JButton();
		Startbutton.setIcon(new ImageIcon("Startw.jpg"));
		Startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.timer.start();
				panel.setVisible(false);
				f.setVisible(true);
				Startbutton.setVisible(false);
				stopMusic();
				startMusic2();
				
			}
		});
		Startbutton.setBounds(574, 350, 245, 100);
		panel.add(Startbutton);
		
		JLabel BGHome = new JLabel("");
		BGHome.setIcon(new ImageIcon("BGHome.png"));
		BGHome.setBounds(0, 0, 893, 633);
		panel.add(BGHome);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void stopMusic() {
		AudioPlayer.player.stop(as);
	}
	public void startMusic2() {
		AudioPlayer.player.start(as2);
	}
	
	
/*	private void initialize() {
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Fish2.png"));
		frame.setBounds(100, 100, 911, 681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().addMouseListener(new Mouse());
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 893, 633);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		FishPanel f = new FishPanel();
		f.setBounds(0, 0, 893, 633);
		f.setVisible(false);
		frame.getContentPane().add(f);
		f.setLayout(null);
		//f.addKeyListener(new Key());
		f.addMouseListener(new Mouse(f));
		
		JTextField field = new JTextField(20);
		field.addKeyListener(new Key());
		panel.add(field);
		
		JButton Startbutton = new JButton();
		Startbutton.setIcon(new ImageIcon("Startw.png"));
		Startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.timer.start();
				panel.setVisible(false);
				f.setVisible(true);
				Startbutton.setVisible(false);
				stopMusic();
				startMusic2();
				
			}
		});
		Startbutton.setBounds(574, 290, 219, 97);
		panel.add(Startbutton);
		
		JLabel BGHome = new JLabel("");
		BGHome.setIcon(new ImageIcon("BGHome.png"));
		BGHome.setBounds(0, 0, 893, 633);
		panel.add(BGHome);		
	}*/
}
