//*******************************************************************************
//Purpose:  Create GUI Number Conversion
//
//Author:   Amanda Seasholtz
//  
//Course:   CS1302
//
//Date:     11/27/17
//
//Program:  MyNumberConversion.java
//**************************************************************************
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//beginning
public class MyNumberConversion extends Application {
    @Override
    //***************************************************
    //Creating an starting point
    //***************************************************
    public void start(Stage primaryStage) throws Exception {
        ConverterPane pane = new ConverterPane();
        primaryStage.setTitle("Number Coverter");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
   
    //***************************************************
    //Creating an Pane that has the text fields and labels
    //***************************************************
    private class ConverterPane extends GridPane {
    	  Integer integer = 0;
    	  //Labels
    	  Label labelDecimal = new Label("Decimal Form:");
        Label labelBinary = new Label("Binary Form:");
        Label labelHexagon = new Label("Hex Form:");

        //TextFields
        TextField tfDecimal = new TextField();
        TextField tfHexagon = new TextField();
        TextField tfBinary = new TextField();

        private ConverterPane() {
            setVgap(15);
            setHgap(15);
            setPadding(new Insets(15, 15, 15, 15));

            //Creating an textFeild for Decimal, Hex, and Binary
            TextField[] textF = new TextField[3];

            // adding an textFeild label for Decimal (row 0)
            add(labelDecimal, 0, 0);
            add(tfDecimal, 1, 0);
            textF[0] = tfDecimal;

            // adding an textFeild label for Decimal (row 1)
            add(labelHexagon, 0, 1);
            add(tfHexagon, 1, 1);
            textF[1] = tfHexagon;

            // adding an textFeild label for Decimal (row 2)
            add(labelBinary, 0, 2);
            add(tfBinary, 1, 2);
            textF[2] = tfBinary;


            // Creating a for loop to make sure that the 
            // Text field centered
            for (int i = 0; i < textF.length; i++) {
                textF[i].setText("0");
                textF[i].setAlignment(Pos.CENTER_RIGHT);
            }
            // Updating the Decimal 
            tfBinary.setOnAction(e-> {
                integer = Integer.parseInt(tfBinary.getText(), 2);
                update();
            });

            // Updating the Decimal 
            tfDecimal.setOnAction(e -> {
                integer = new Integer(tfDecimal.getText());
                update();
            });
            // Updating the Hex
            tfHexagon.setOnAction(e -> {
                integer = Integer.parseInt(tfHexagon.getText(), 16);
                update();
            });
        }
        //***************************************************
        // creating a method that will help update the method
        //***************************************************
        private void update() {
            tfDecimal.setText(integer.toString());
            tfHexagon.setText(Integer.toHexString(integer));
            tfBinary.setText(Integer.toBinaryString(integer));
        }
    }
    //******************************************
    // main method to run the code
    //******************************************
    public static void main(String[] args) {
        Application.launch(args);
    }
}