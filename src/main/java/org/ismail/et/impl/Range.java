package org.ismail.et.impl;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import org.ismail.et.impl.Frame;

public class Range {
	
	static class Variables extends Range{

		private static ChoiceBox<String> lowChoice;
		private static ChoiceBox<String> highChoice;
		static Button setRange;
		static Stage window;
		
	}
	
	public Range(){
		
		Variables.window = new Stage();
		Variables.lowChoice = new ChoiceBox<String>();
		Variables.highChoice = new ChoiceBox<String>();
		//new Variables();
		
	}
	
	public static void change(){
		
		int low = Frame.Note2Midi( Variables.lowChoice.getValue() );
		//System.out.println("asd");
		Frame.getNote().setStartPitch( low  );
		Frame.setIntLow( Variables.lowChoice.getValue() );
		
		int high = Frame.Note2Midi( Variables.highChoice.getValue() );
		Frame.getNote().setInterval( high - low );
		Frame.setIntHigh( Variables.highChoice.getValue() );
		
	}
	
	public static void setRange(){
		
		
		
		Variables.window.setTitle( "Range" );
		Variables.window.initModality( Modality.APPLICATION_MODAL );
		Variables.window.setMinHeight(130);
		Variables.window.setMinWidth(180);
		
		Variables.setRange = new Button();
		Variables.setRange.setText("Apply");
		
		
		GridPane gpane = new GridPane();
		gpane.setPadding( new Insets(5, 5, 5, 5));
		gpane.setVgap(10);
		gpane.setHgap(5);
		
		Label low = new Label("Lowest Pitch");
		Label high = new Label("Highest Pitch");
		
		
		Variables.lowChoice.getItems().addAll("E2", "F2", "F#2", "G2", "G#2", "A2", "A#2", "B2", "C3", "C#3", "D3", "D#3", "E3", "F3");
		Variables.lowChoice.setValue( Frame.getIntLow() );
		
		
		Variables.highChoice.getItems().addAll( "D4", "D#4", "E4", "F4", "F#4", "G4", "G#4", "A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5");
		Variables.highChoice.setValue( Frame.getIntHigh() );
		
		gpane.setConstraints(Variables.highChoice, 0, 0);
		gpane.setConstraints(Variables.lowChoice, 1, 0);
		gpane.setConstraints(high, 0, 1);
		gpane.setConstraints(low, 1, 1);
		gpane.setConstraints(Variables.setRange, 1, 3);
		
		gpane.getChildren().addAll( Variables.highChoice, high, Variables.lowChoice, low, Variables.setRange );
		Scene scene = new Scene(gpane);
		Variables.window.setScene(scene);
		
		Variables.setRange.setOnAction(new EventHandler<ActionEvent> (){
			
			//@Override
			public void handle(ActionEvent event) {
				change();
				Variables.window.close();
			}
			
		});
		Variables.window.showAndWait();

		
	}

	public ChoiceBox<String> getLowChoice() {
		return Variables.lowChoice;
	}

	public void setLowChoice(ChoiceBox<String> lowC) {
		Variables.lowChoice = lowC;
	}

	public static ChoiceBox<String> getHighChoice() {
		return Variables.highChoice;
	}

	public static void setHighChoice(ChoiceBox<String> highC) {
		Variables.highChoice = highC;
	}
	

	
	
}
