package com.example.demons.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StartController {
    @FXML
    public ImageView Logo,allTasks,addTask;
    public void goToHomePage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/start.fxml"));
            Parent root = loader.load();
            StartController controller = loader.getController();
            Scene scene = Logo.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void goToAddTask(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/AddTask.fxml"));
            Parent root = loader.load();
            StartController controller = loader.getController();
            Scene scene = Logo.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
