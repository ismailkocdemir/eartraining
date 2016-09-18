package org.ismail.et.impl;

import javax.sound.midi.*;


public class MidiNote {
	
	
	public static void playNote() {
	
		try{
			Synthesizer synth = MidiSystem.getSynthesizer();
			Instrument[] instruments = synth.getDefaultSoundbank().getInstruments();
			MidiChannel[] channels = synth.getChannels();
			
			synth.loadInstrument( instruments[0] );
			
			channels[0].noteOn(60, 100);
			System.out.println("Note on");
//			try{
//				Thread.sleep(5000);
//			}
//			catch( InterruptedException e){
//				System.out.println(e);
//			}
			
			//channels[0].noteOff(60);
		
		}
		catch(MidiUnavailableException e){
			System.out.println(e);
		}
	}
	
	
	
}
