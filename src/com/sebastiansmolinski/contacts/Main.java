package com.sebastiansmolinski.contacts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("My Contacts");
        primaryStage.setScene(new Scene(root, 600, 440));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
