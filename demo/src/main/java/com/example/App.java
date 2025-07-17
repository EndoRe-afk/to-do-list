package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application{

    private static Scene homePage, newList;  // Creating new scene / content inside your application window
    private Button button;

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("My to do list :))");

        Label label = new Label("To do List APP");

        button = new Button();  // Creates a simple button
        button.setText("Create new list"); // Gives a button a text
        Button viewList = new Button("Don't press this");

        // 
        
        
        // Now to create a layout for our application
        StackPane mainLayout = new StackPane();   // creates an available stack for us to stack text and objects
        mainLayout.getChildren().add(button);

        // Scene represents the content inside your window
        homePage = new Scene(mainLayout, 200, 100);  // first parameter of your scene is the object in question e.g layout
                                              // second parameter is width, third is height
        stage.setScene(homePage);  //sets the content (the layout and UI elements) that will be displayed in the application window.
        stage.show(); // makes window visible to user

        button.setOnAction(e -> {
            TaskManager taskManager = new TaskManager();
            createScene(stage);
        });
        // You can also use a separate class to handle this action.
    }

    public void createScene(Stage stage) {


        HBox backButtonPane = new HBox();
        Button backHomeButton = new Button();  // Creates a back to home button
        backHomeButton.setText("Back to Home"); // Gives a button a text
        backHomeButton.setPrefHeight(20);
        backHomeButton.setPrefWidth(100);
        backButtonPane.setAlignment(Pos.BOTTOM_RIGHT);
        
        backHomeButton.setOnAction( e -> { 
            stage.setScene(homePage);  //sets the content (the layout and UI elements) that will be displayed in the application window.
            stage.show(); // makes window visible to user})
        });


        // Creates layout for a stack of objects
        VBox listLayout = new VBox();
        // User inserts text for the to do list
        TextField item = createTextField(listLayout);


        backButtonPane.getChildren().add(backHomeButton);
        
        StackPane rootPane = new StackPane();
        rootPane.getChildren().addAll(listLayout, backButtonPane);

        newList = new Scene(rootPane, 500, 200);
        stage.setScene(newList);
        stage.show();
    }

    private TextField createTextField(VBox container) {
        TextField textField = new TextField();
        textField.setPromptText("Type and press Enter");
        container.getChildren().add(textField);

        textField.setOnAction(event -> {
            TextField newField = createTextField(container);
            container.getChildren().add(newField);
            newField.requestFocus(); // Move focus to the new TextField
        });

        return textField;
    }
        

    // public HBox createHBox(Stage stage){
    //     HBox hbox = new HBox();
    //     hbox.setPadding(new Insets(15, 12, 15, 12));
    //     hbox.setSpacing(10);
    //     hbox.setStyle("-fx-background-color: #336699;");

    //     Button buttonCurrent = new Button("Current");
    //     buttonCurrent.setPrefSize(100, 20);

    //     Button buttonProjected = new Button("Projected");
    //     buttonProjected.setPrefSize(100, 20);
    //     hbox.getChildren().addAll(buttonCurrent, buttonProjected);

    //     return hbox;
    // }

    public static void main(String[] args) {
        launch();
    }

}