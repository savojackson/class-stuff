//*******************************************************************************
//Purpose:  Create GUI Radio Buttons
//
//Author:   Amanda Seasholtz & Savon Jackson
//  
//Course:   CS1302
//
//Date:     11/27/17
//
//Program:  MyRadioButtons.java
//**************************************************************************
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class MyRadioButtons extends Application {
	protected Text text = new Text(50, 50, "Programming is fun!");
	@Override 
	//***********************************************
   // Create a pane and set its properties
	//***********************************************
	public void start(Stage primaryStage) {
		HBox HBoxPanes = new HBox(20);
		Button btLeft = new Button("<=");
		Button btRight = new Button("=>");
		HBoxPanes.getChildren().addAll(btLeft, btRight);
		HBoxPanes.setAlignment(Pos.CENTER);
		BorderPane pane = new BorderPane();
		pane.setBottom(HBoxPanes);

		HBox paneForRadioButtons = new HBox(20);
		RadioButton redButton = new RadioButton("Red");
		RadioButton yellowButton = new RadioButton("Yellow");
		RadioButton blackButton = new RadioButton("Black");
		RadioButton orangeButton = new RadioButton("Orange");
		RadioButton greenButton = new RadioButton("Green");
		paneForRadioButtons.getChildren().addAll(redButton, yellowButton, blackButton, orangeButton, greenButton);

		ToggleGroup stage = new ToggleGroup();
		redButton.setToggleGroup(stage);
		yellowButton.setToggleGroup(stage);
		blackButton.setToggleGroup(stage);
		orangeButton.setToggleGroup(stage);
		greenButton.setToggleGroup(stage);

		Pane textpane = new Pane();
		textpane.setStyle("-fx-border-color: pink");
		textpane.getChildren().add(text);
		pane.setCenter(textpane);
		pane.setTop(paneForRadioButtons);

	   //handler
		btLeft.setOnAction(e -> text.setX(text.getX() - 10));
		btRight.setOnAction(e -> text.setX(text.getX() + 10));

		redButton.setOnAction(e -> {
			if (redButton.isSelected()) {
				text.setFill(Color.RED);
			}
		});

		yellowButton.setOnAction(e -> {
			if (yellowButton.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});

		blackButton.setOnAction(e -> {
			if (blackButton.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});

		orangeButton.setOnAction(e -> {
			if (orangeButton.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});

		greenButton.setOnAction(e -> {
			if (greenButton.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});

		// Creating a scene and place them in the proper stage
		Scene scene = new Scene(pane, 400, 150);
		primaryStage.setTitle("Radio Button"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	
	 //******************************************
    // main method to run the code
    //******************************************
    public static void main(String[] args) {
        launch(args);
      }
}



