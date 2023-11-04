package com.example.demons;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), javafx.stage.Screen.getPrimary().getVisualBounds().getWidth(), javafx.stage.Screen.getPrimary().getVisualBounds().getHeight());
        stage.setTitle("TaDo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}