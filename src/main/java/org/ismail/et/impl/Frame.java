package org.ismail.et.impl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import org.ismail.et.impl.MidiNote;
import org.ismail.et.impl.Range;
//import org.ismail.et.impl.Events;

public class Frame extends Application {

	private static MidiNote note;
	Button randomPitch;
	Button repeatPitch;
	Button changeRange;
	private static String intHigh;
	private static String intLow;
	
	//Events events;
	
	public static void main( String[] args ){
		
		launch(args);
		
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		
		mainStage.setTitle("Random Pitch Generator");
		
		note = new MidiNote();
		intLow =  "A2";
		intHigh = "G4";
		
		randomPitch = new Button();
		randomPitch.setText("Random Pitch");
		randomPitch.setOnAction( new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				note.playNote();
				
			}
				
		});
		
		repeatPitch = new Button();
		repeatPitch.setText("Repeat");
		repeatPitch.setOnAction( new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//System.out.println( "number: " + Note2Midi("C3"));
				note.playAgain();
				
			}
			
		});
		
		changeRange = new Button();
		changeRange.setText("Change Range");
		changeRange.setOnAction( new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Range range = new Range();
				range.setRange();
				
			}
			
		});
		
		GridPane gpane = new GridPane();
		gpane.setPadding( new Insets(5, 5, 5, 5) );
		gpane.setVgap(5);
		gpane.setHgap(10);

		gpane.setConstraints(randomPitch, 0, 0);
		gpane.setConstraints(repeatPitch, 1, 0);
		gpane.setConstraints(changeRange, 2, 2);
		gpane.getChildren().addAll(randomPitch, repeatPitch, changeRange);
		//gpane.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(gpane, 400, 200);
		mainStage.setScene(scene);
		mainStage.show();
		
		
	}
	
	public static int Note2Midi( String note ){
		
		int octave = 60;
		
		//if(note.length() != 2 || note.length() != 3 ) return -1;
		
		int i = 1;
		if( note.length() == 3) i++;
		
		switch( note.charAt(i) ){
			case '1':
				octave = 24;
				break;
			case '2':
				octave = 36;
				break;
			case '3':
				octave = 48;
				break;
			case '4':
				octave = 60;
				break;
			case '5':
				octave = 72;
				break;
			case '6':
				octave = 84;
				break;
			default:
				octave = 60;
		}
		
		
		switch( note.charAt(0))
		{
			case 'A':
				if(i == 2){
					octave++;
				}
				octave = octave + 9;
				break;
			case 'B':
				if(i == 2){
					octave++;
				}
				octave = octave + 11;
				break;
			case 'C':
				if(i == 2){
					octave++;
				}
				break;
			case 'D':
				if(i == 2){
					octave++;
				}
				octave = octave + 2;
				break;
			case 'E':
				if(i == 2){
					octave++;
				}
				octave = octave + 4;
				break;
			case 'F':
				if(i == 2){
					octave++;
				}
				octave = octave + 5;
				break;
			case 'G':
				if(i == 2){
					octave++;
				}
				octave = octave + 7;
				break;
			default:
				return octave;
		}
		
		return octave;
		
	}
	
	public static void setIntLow( String low ){
		intLow = low;
	}
	
	public static void setIntHigh( String high ){
		intHigh = high;
	}
	
	public static String getIntHigh(){
		return intHigh;
	}
	
	public static String getIntLow(){
		return intLow;
	}
	
	public static MidiNote getNote(){
		return note;
	}


}
