package org.ismail.et.impl;

import java.util.Random;

import jm.music.data.Note;
import jm.util.Play;


public class MidiNote {
	
	private int prevNote;
	private int pitch;
	private int startPitch;
	private int interval;
	Note[] note;
	
	
	public MidiNote(){
		
		prevNote = 60;
		pitch = 60;
		startPitch = 45;
		interval = 22;
		
		note = new Note[38];
		for(int i = 0; i < 38; i++){
			note[i] = new Note();
			note[i].setPitch(i + 40);
		}
		
	}
	
	public void playNote() {
		
		Random random = new Random();
		pitch = random.nextInt(interval);
		
		
		prevNote = startPitch + pitch;
		//System.out.println( prevNote );
		Play.midi(note[prevNote-40]);

	}
	
	public void playAgain(){
		
		Note note = new Note();
		note.setPitch(prevNote);
		Play.midi( note );
		
	}
	
	public void setStartPitch( int spitch ){
		startPitch = spitch;
	}
	
	public void setInterval( int inter){
		interval = inter;
	}
	
	public int getStartPitch(){
		return startPitch;
	}
	
	public int getInterval(){
		return interval;
	}
	
	
}
