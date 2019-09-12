//*******************************************************************************
//Purpose:  Create GUI Mile/Kilometer Conversion
//
//Author:   Amanda Seasholtz & Savon Jackson
//  
//Course:   CS1302
//
//Date:     11/27/17
//
//Program:  MyMileKilometerConversion.java
//**************************************************************************
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//beginning of class
public class MyMileKilometerConversion extends Application {
    @Override
   //***********************************************
   // Create a pane and set its properties
	//***********************************************
    public void start(Stage primaryStage) throws Exception {
        MilesAndKiloPane pane = new MilesAndKiloPane();
        primaryStage.setTitle(" Calculator for Kilo and Mile");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }//end of start
    //*****************************************
    // Creating a method that will create labels and text Fields    
    //*****************************************    
    private class MilesAndKiloPane extends GridPane {
      //Creating labels
    	Label labelMiles = new Label("The amount of Mile:");
      Label labelKilo = new Label("The amount of Kilometers:");

      //Creating text field
      TextField tfMiles = new TextField();
      TextField tfKilo = new TextField();

      private MilesAndKiloPane() {
         setHgap(10);
         setVgap(10);
         setPadding(new Insets(10, 10, 10, 10));
         
         //Adding Labels and Text fields
         add(labelMiles, 0, 0);
         add(tfMiles, 1, 0);
         add(labelKilo, 0, 1);
         add(tfKilo, 1, 1);            
         //Setting the proper location
         tfMiles.setText("0");
         tfMiles.setAlignment(Pos.CENTER_RIGHT);
         tfKilo.setText("0");
         tfKilo.setAlignment(Pos.CENTER_RIGHT);

         //handler
         tfKilo.setOnAction(e->{
            tfMiles.setText(Double.toString(new Double(tfKilo.getText()) * 0.621371));
         }
         );

         tfMiles.setOnAction(e->{
            tfKilo.setText(Double.toString(new Double(tfMiles.getText()) / 0.621371));
            });
        }
    }//end of class
    
    //******************************************
    // main method to run the code
    //******************************************
    public static void main(String[] args) {
        Application.launch(args);
    }
}//end of class