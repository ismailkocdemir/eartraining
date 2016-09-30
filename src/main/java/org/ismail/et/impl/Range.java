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
	
	private static ChoiceBox<String> lowChoice;
	private static ChoiceBox<String> highChoice;
	static Button setRange;
	
	public static void change(){
		
		
		int low = Frame.Note2Midi( lowChoice.getValue() );
		Frame.getNote().setStartPitch( low  );
		Frame.setIntLow( lowChoice.getValue() );
		
		int high = Frame.Note2Midi( highChoice.getValue() );
		Frame.getNote().setInterval( high - low );
		Frame.setIntHigh( highChoice.getValue() );
		
	}
	
	public static void setRange(){
		
		final Stage window = new Stage();
		window.setTitle( "Range" );
		window.initModality( Modality.APPLICATION_MODAL );
		window.setMinHeight(200);
		window.setMinWidth(200);
		
		setRange = new Button();
		setRange.setText("Apply");
		
		
		
		
		GridPane gpane = new GridPane();
		gpane.setPadding( new Insets(5, 5, 5, 5));
		gpane.setVgap(10);
		gpane.setHgap(5);
		
		Label low = new Label("Bottom Note");
		Label high = new Label("Top Note");
		
		ChoiceBox<String> lowChoice = new ChoiceBox<String>();
		lowChoice.getItems().addAll("E2", "F2", "F#2", "G2", "G#2", "A2", "A#2", "B2", "C3", "C#3", "D3", "D#3", "E3", "F3");
		lowChoice.setValue( Frame.getIntLow() );
		
		ChoiceBox<String> highChoice = new ChoiceBox<String>();
		highChoice.getItems().addAll( "D4", "D#4", "E4", "F4", "F#4", "G4", "G#4", "A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5");
		highChoice.setValue( Frame.getIntHigh() );
		
		gpane.setConstraints(highChoice, 0, 0);
		gpane.setConstraints(lowChoice, 1, 0);
		gpane.setConstraints(high, 0, 1);
		gpane.setConstraints(low, 1, 1);
		gpane.setConstraints(setRange, 1, 2);
		
		gpane.getChildren().addAll( highChoice, high, lowChoice, low, setRange );
		Scene scene = new Scene(gpane);
		window.setScene(scene);
		
		setRange.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				change();
				window.close();
			}
			
		});
		window.showAndWait();

		
	}

	public static ChoiceBox<String> getLowChoice() {
		return lowChoice;
	}

	public static void setLowChoice(ChoiceBox<String> lowChoice) {
		Range.lowChoice = lowChoice;
	}

	public static ChoiceBox<String> getHighChoice() {
		return highChoice;
	}

	public static void setHighChoice(ChoiceBox<String> highChoice) {
		Range.highChoice = highChoice;
	}
	

	
	
}
