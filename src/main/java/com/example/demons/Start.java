package com.example.demons;

import com.example.demons.Controllers.StartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("start.fxml"));
        Parent root = fxmlLoader.load(); // Load the FXML and get the root

        StartController controller = fxmlLoader.getController();
        // Now, you can access the controller and its elements

        // If you need to access the scroll pane in your controller, use the controller reference:
        controller.scroll_pane.setFocusTraversable(true);

        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("TaDo");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}