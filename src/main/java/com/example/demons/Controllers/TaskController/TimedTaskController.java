package com.example.demons.Controllers.TaskController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TimedTaskController extends TaskController{
    @FXML
    public Label deadline;
    @FXML
    public VBox border;

    @Override
    public void viewTask(ActionEvent actionEvent) throws IOException {
        super.viewTask(actionEvent);
        LoadView.initializeView(this.Task,controller);
    }
}
