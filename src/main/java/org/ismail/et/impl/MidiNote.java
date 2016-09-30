package org.ismail.et.impl;

import java.util.Random;

import jm.music.data.Note;
import jm.util.Play;


public class MidiNote {
	
	private int prevNote;
	private int pitch;
	private int startPitch;
	private int interval;
	
	
	public MidiNote(){
		
		prevNote = 60;
		pitch = 60;
		startPitch = 45;
		interval = 22;
	}
	
	public void playNote() {
		
		Random random = new Random();
		pitch = random.nextInt(interval);
		
		Note note = new Note();
		note.setPitch( startPitch + pitch);
		prevNote = startPitch + pitch;
		System.out.println( prevNote );
		Play.midi(note);

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
