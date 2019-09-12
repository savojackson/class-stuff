//*******************************************************************************
//Purpose:  Create GUI Bonus1
//
//Author:   Amanda Seasholtz & Savon Jackson
//  
//Course:   CS1302
//
//Date:     11/27/17
//
//Program:  Bonus1.java
//**************************************************************************
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
//begining of class
public class Bonus1 extends Application{
   @Override
   public void start(Stage primaryStage){
      ImageView iv = new ImageView();
      Image image = new Image("pic.jpg");
      iv.setImage(image);
      //fade specifications
      FadeTransition ft = new FadeTransition();
      ft.setNode(iv);
      ft.setDuration(new Duration(2000));
      ft.setFromValue(1.0);
      ft.setToValue(0.0);
      ft.setCycleCount(6);
      ft.setAutoReverse(true);
      ft.play();
      //root to add children
      Group root = new Group();
      root.getChildren().add(iv);
      Scene scene = new Scene(root, image.getWidth(), image.getHeight());
      //puts in stage
      primaryStage.setTitle("Bonus 1!!!");
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