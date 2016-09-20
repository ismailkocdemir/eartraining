package org.ismail.et.impl;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ismail.et.impl.MidiNote;

public class Frame {
	
	private JFrame frame;
	private JPanel panel;
	private JButton buttonPlay;
	private JButton buttonRepeat;
	MidiNote note;
	//private JLabel label;
	
	public Frame(){
		
		note = new MidiNote();
		box();
		
	}
	
	public void box(){
		
		frame = new JFrame("Random Pitch Generator");
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		
		buttonPlay = new JButton("Play new note");
		buttonRepeat = new JButton("Repeat");
		//label = new JLabel("Test Label");
		buttonPlay.addActionListener( new ActionListener(){
			
			public void actionPerformed( ActionEvent acEvent ){
				
				note.playNote();
			}
			
		});
		
		buttonRepeat.addActionListener( new ActionListener(){
			
			public void actionPerformed( ActionEvent acEvent){
				
				note.playAgain();
				
			}
			
		});
		
		panel.add(buttonPlay);
		panel.add(buttonRepeat);
		//panel.add(label);
		
		frame.add(panel);
		
	}
	
	public static void main( String[] args ){
		
		new Frame();
		
	}
}
