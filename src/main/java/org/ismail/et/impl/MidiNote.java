package org.ismail.et.impl;

import java.util.Random;

import jm.music.data.Note;
import jm.util.Play;


public class MidiNote {
	
	static int prevNote;
	
	public MidiNote(){
		
		prevNote = 60;
		
	}
	
	public void playNote() {
		
		int pitch;
		
		Random random = new Random();
		pitch = random.nextInt(29);
		
		Note note = new Note();
		note.setPitch( 43 + pitch);
		prevNote = 43 + pitch;
		
		Play.midi(note);
		
	}
	
	public void playAgain(){
		
		Note note = new Note();
		note.setPitch(prevNote);
		Play.midi( note );
		
	}
	
	
	
}
