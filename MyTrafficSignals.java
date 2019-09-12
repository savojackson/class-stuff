//*******************************************************************************
//Purpose:  Create GUI Traffic Signals
//
//Author:   Amanda Seasholtz & Savon Jackson
//  
//Course:   CS1302
//
//Date:     11/27/17
//
//Program:  MyTrafficSignals.java
//**************************************************************************
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;

public class MyTrafficSignals extends Application {
	@Override 
	public void start(Stage primaryStage) {
		// Create an Vbox
		VBox CirclePane = new VBox(10);
		CirclePane.setAlignment(Pos.CENTER);

		// Create circles and put in VBox
		Circle c1 = getCircle();
		Circle c2 = getCircle();
		Circle c3 = getCircle();
		c1.setFill(Color.RED);
		CirclePane.getChildren().addAll(c1, c2, c3);

		// Making rectangle
		Rectangle rectangle = new Rectangle();
		rectangle.setFill(Color.WHITE);
		rectangle.setWidth(45);
		rectangle.setHeight(115);
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(7);
		StackPane stackPane = new StackPane(rectangle, CirclePane);

		// Create a hbox
		HBox HBoxPane = new HBox(5);
		HBoxPane.setAlignment(Pos.CENTER);

		// Create radio buttons
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbGreen = new RadioButton("Green");

		// Create a toggle group
		ToggleGroup tgroup = new ToggleGroup();
		rbRed.setToggleGroup(tgroup);
		rbYellow.setToggleGroup(tgroup);
		rbGreen.setToggleGroup(tgroup);
		rbRed.setSelected(true);
		HBoxPane.getChildren().addAll(rbRed, rbYellow, rbGreen);

		// Create a border pane
		BorderPane Bpane = new BorderPane();
		Bpane.setCenter(stackPane);
		Bpane.setBottom(HBoxPane);

		//handler
		rbRed.setOnAction(e -> {
			if (rbRed.isSelected()) {
				c1.setFill(Color.RED);
				c2.setFill(Color.WHITE);
				c3.setFill(Color.WHITE);
			}
		});
		rbYellow.setOnAction(e -> {
			if (rbYellow.isSelected()) {
				c1.setFill(Color.WHITE);
				c2.setFill(Color.YELLOW);
				c3.setFill(Color.WHITE);
			}
		});
		rbGreen.setOnAction(e -> {
			if (rbGreen.isSelected()) {
				c1.setFill(Color.WHITE);
				c2.setFill(Color.WHITE);
				c3.setFill(Color.LIME);
			}
		});
		// Create a scene and place it in the proper stage
		Scene scene = new Scene(Bpane, 200, 150);
		primaryStage.setTitle("Traffic Light"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}//end of start
   
	// method that will return a circle 
	private Circle getCircle() {
		Circle c = new Circle(10);
		c.setFill(Color.WHITE);
		c.setStroke(Color.BLACK);
		return c;
	}//end of getCircle
	 //******************************************
    // Creating an main method to run the code
    //******************************************
    public static void main(String[] args) {
    launch(args);
    }//end of main
}//end of class