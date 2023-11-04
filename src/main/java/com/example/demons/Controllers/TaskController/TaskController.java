package com.example.demons.Controllers.TaskController;

import com.example.demons.Models.Task;
import com.example.demons.enums.TaskStatus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class TaskController {
    @FXML
    public Label Title,status_text;
    @FXML
    public Pane status_color;
    @FXML
    public Hyperlink delete,view;
    public Task<?> Task;
    @FXML
    public  void viewTask(ActionEvent actionEvent){

    }
    @FXML
    public  void deleteTask(ActionEvent actionEvent) {

    }


    public void setTitle(String title) {
        Title.setText(title);
    }

    public void setStatus_text(TaskStatus status_text) {
        this.status_text.setText(String.valueOf(status_text.getStatusText()));
    }

    public void setStatus_color(TaskStatus status) {
        String style = "-fx-border-width: 20; -fx-border-style: solid; -fx-border-radius: 20px ;";

        if (status == TaskStatus.COMPLETED) {
            style += "-fx-border-color: green;";
        } else if (status == TaskStatus.IN_PROGRESS) {
            style += "-fx-border-color: red;";
        }

        this.status_color.setStyle(style);
    }
}
