package com.example;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application implements EventHandler<ActionEvent> {

    private static Scene scene;  // Creating new scene / content inside your application window
    private Button button;

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("My to do list :))");

        button = new Button();  // Creates a simple button
        button.setText("Create new list"); // Gives a button a text

        // Now to create a layout for our application
        StackPane layout = new StackPane();   // creates an available stack for us to stack text and objects
        layout.getChildren().add(button);

        // Scene represents the content inside your window
        scene = new Scene(layout, 200, 100);  // first parameter of your scene is the object in question e.g layout
                                              // second parameter is width, third is height
        primaryStage.setScene(scene);  //sets the content (the layout and UI elements) that will be displayed in the application window.
        primaryStage.show(); // makes window visible to user


        button.setOnAction(e -> {
            StackPane listLayout = new StackPane();
            // You can add UI elements to listLayout here if needed
            Scene listScene = new Scene(listLayout, 500, 500);
            primaryStage.setScene(listScene);
            primaryStage.show();
            
        });

    }



    public static void main(String[] args) {
        launch();
    }

    @Override // From there, EventHandler has the method handle which is how you handle the event : clicking of button
    public void handle(ActionEvent buttonClick) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}