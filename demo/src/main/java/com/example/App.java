package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
    private ScrollPane scrollPane;

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("My to do list :))");

        Label label = new Label("To do List APP");

        button = new Button();  // Creates a simple button
        button.setText("Create new list"); // Gives a button a text
        Button viewList = new Button("Don't press this");

    
        // 
        StackPane mainLayout = new StackPane();   // creates an available stack for us to stack text and objects
        mainLayout.getChildren().add(button);

        // Scene represents the content inside your window
        homePage = new Scene(mainLayout, 500, 500);  // first parameter of your scene is the object in question e.g layout
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
        backButtonPane.setStyle("-fx-alignment: bottom-right; -fx-padding: 10;");
        
        backHomeButton.setOnAction( e -> { 
            stage.setScene(homePage);  //sets the content (the layout and UI elements) that will be displayed in the application window.
            stage.show(); // makes window visible to user})
        });

        backButtonPane.getChildren().add(backHomeButton);


        // Creates layout for a stack of objects
        VBox listLayout = new VBox();
        // User inserts text for the to do list

        addNewField(listLayout);

        // TextField textField = createTextField(listLayout);
        // textField.setPromptText("Type and press Enter");
        // listLayout.getChildren().add(textField);


        scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);  // Make scroll pane width match content
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        
        
        StackPane rootPane = new StackPane();
        rootPane.getChildren().addAll(listLayout, backButtonPane, scrollPane);

        newList = new Scene(rootPane, 500, 200);
        scrollPane.setContent(listLayout);
        stage.setScene(newList);
        stage.show();
    }

    // Add a new textbox
    private void addNewField(VBox listLayout) {
        // Disable Enter handling on previous last field (if any)
        listLayout.getChildren().forEach(node -> {
            if (node instanceof TextField) {
                ((TextField) node).setOnAction(null);
            }
        });

        // Create new field and add to layout
        TextField newField = new TextField();
        newField.setPromptText("Type and press Enter");
        newField.setEditable(true);

        // Only allow the newest one to create the next one
        newField.setOnAction(event -> {
            if (!newField.getText().trim().isEmpty()) {
                addNewField(listLayout);
            }
        });

        listLayout.getChildren().add(newField);

        // Ensure focus moves to this new field
        Platform.runLater(() -> {
            newField.requestFocus();
            scrollPane.setVvalue(1.0);  // Scroll to bottom
        });
    }


    // private TextField createTextField(VBox container) {
    //     TextField textField = new TextField();
    //     textField.setPromptText("Type and press Enter");
    //     container.getChildren().add(textField);

    //     textField.setOnAction(event -> {
    //         TextField newField = createTextField(container);
    //         container.getChildren().add(newField);
    //         newField.requestFocus(); // Move focus to the new TextField
    //     });

    //     return textField;
    // }
        

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