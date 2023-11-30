package com.example.demons;

import com.example.demons.Controllers.StartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Start the application
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("start.fxml"));
        StartController controller = fxmlLoader.getController();
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setTitle("TaDo");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}