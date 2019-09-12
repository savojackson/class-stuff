//*******************************************************************************
//Purpose:  Create GUI Animation
//
//Author:   Amanda Seasholtz & Savon Jackson
//  
//Course:   CS1302
//
//Date:     11/27/17
//
//Program:  MyMileKilometerConversion.java
//**************************************************************************
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

//beginning
public class Bonus2 extends Application {
    @Override
    public void start(Stage stage) {
        initUI(stage);
    }
    private void initUI(Stage stage) {
        Pane root = new Pane();
        Rectangle r = new Rectangle(225, 225, 100, 100);
        r.setArcHeight(10);
        r.setArcWidth(10);
        r.setFill(Color.BLUE);
        RotateTransition rottr = new RotateTransition(Duration.millis(2000), r);
        rottr.setByAngle(180);
        rottr.setCycleCount(4);
        rottr.setAutoReverse(true);
        
        ScaleTransition s = new ScaleTransition(Duration.millis(2000),r);
        s.setByX(2);
        s.setByY(2);
        s.setCycleCount(4);
        s.setAutoReverse(true);
        //set colors. 
        FillTransition fltr = new FillTransition(Duration.millis(2000),r, Color.GREEN, Color.RED);
        fltr.setCycleCount(4);
        fltr.setAutoReverse(true);
        root.getChildren().add(r);
        ParallelTransition p = new ParallelTransition();
        p.getChildren().addAll(rottr, s, fltr);
        p.play();    
        // set Scene size
        Scene scene = new Scene(root, 500, 550);
        //labael 
        stage.setTitle("Transition");
        stage.setScene(scene);
        stage.show();
    }
     //Main Method to run
     public static void main(String[] args) {
        launch(args);
    }
  }