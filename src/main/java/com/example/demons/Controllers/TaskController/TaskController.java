package com.example.demons.Controllers.TaskController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public abstract class TaskController {
    @FXML
    public Label Title,status_text;
    @FXML
    public Pane status_color;
    @FXML
    public Hyperlink delete,view;
    @FXML
    public void viewTask(ActionEvent actionEvent) {

    }
    @FXML
    public void deleteTask(ActionEvent actionEvent) {

    }
}
