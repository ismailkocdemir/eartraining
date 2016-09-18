package org.ismail.et.impl;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ismail.et.impl.MidiNote;

public class Frame {
	
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	//private JLabel label;
	
	public Frame(){
		box();
	}
	
	public void box(){
		
		frame = new JFrame("Test");
		frame.setVisible(true);
		frame.setSize(100, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		
		button = new JButton("Play");
		//label = new JLabel("Test Label");
		button.addActionListener( new ActionListener(){
			
			public void actionPerformed( ActionEvent acEvent ){
				MidiNote.playNote();
			}
			
		});
		
		
		panel.add(button);
		//panel.add(label);
		
		frame.add(panel);
		
	}
	
	public static void main( String[] args ){
		
		new Frame();
		
	}
}
