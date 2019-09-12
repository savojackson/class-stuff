//*******************************************************************************
//Purpose:  Create GUI Geometric Figures
//
//Author:   Amanda Seasholtz & Savon Jackson
//  
//Course:   CS1302
//
//Date:     11/27/17
//
//Program:  MyGeometricFigures.java
//**************************************************************************
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

public class MyGeometricFigures extends Application {
   //Declarations
	public Circle circle = new Circle(50);	// Create a circle
	public Rectangle rectangle = new Rectangle(); // Create a Rectangle
	public Ellipse ellipse = new Ellipse(); // Crate an Ellipse

	@Override 
	//***********************************************
    // Create a pane and set its properties. This 
	// will build the costume pane calling calling 
	// build my pane method.
	//***********************************************
	public void start(Stage primaryStage) {
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		rectangle.setStroke(Color.BLACK);
		rectangle.setWidth(200);
		rectangle.setFill(Color.WHITE);
		rectangle.setHeight(125);
		ellipse.setFill(Color.WHITE);
		ellipse.setStroke(Color.BLACK);
		ellipse.setRadiusX(125);
		ellipse.setRadiusY(75);

		// Create a HBox to hold buttons
		HBox paneForButtons = new HBox(5);
		paneForButtons.setAlignment(Pos.CENTER);
		RadioButton circleButton = new RadioButton("Circle"); 
		RadioButton rectangleButton = new RadioButton("Rectangle"); 
		RadioButton ellipseButton = new RadioButton("Ellipse"); 

		// Creating an ToggleGroup for the shapes
		ToggleGroup groupingShapes = new ToggleGroup();
		circleButton.setToggleGroup(groupingShapes);
		rectangleButton.setToggleGroup(groupingShapes);
		ellipseButton.setToggleGroup(groupingShapes);
		
		// Creating an check box and making it filled
		CheckBox FillCheck = new CheckBox("Fill");

		// Put all the buttons in the hbox
		paneForButtons.getChildren().addAll(circleButton, 
			rectangleButton, ellipseButton, FillCheck);

		// Creating a stack pane that will hold the shapes
		StackPane paneForShapes = new StackPane();
		paneForShapes.setStyle("-fx-border-color: blue");

		// Creating a border pane that will hold all the nodes
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);
		pane.setCenter(paneForShapes);

		// Create and register handler for circle,rectangle, ellipse, and fill check 
		circleButton.setOnAction(e -> {
			if (circleButton.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(circle);
			}
		});
		rectangleButton.setOnAction(e -> {
			if (rectangleButton.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(rectangle);
			}
		});
		ellipseButton.setOnAction(e -> {
			if (ellipseButton.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(ellipse);
			}
		});
		FillCheck.setOnAction(e -> {
			if (FillCheck.isSelected()) {
				circle.setFill(Color.RED);
				rectangle.setFill(Color.LIME);
				ellipse.setFill(Color.PURPLE);

			} else {
				circle.setFill(Color.WHITE);
				rectangle.setFill(Color.WHITE);
				ellipse.setFill(Color.WHITE);			}
		});

		// Creating a scene and place with stages
		Scene scene = new Scene(pane, 500, 250);
		primaryStage.setTitle("Geometric Figures"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	//*************************************
	// main method to run the program
   //*************************************	
	public static void main(String[] args) {
	    launch(args);
	  }
}