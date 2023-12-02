package com.example.demons.Controllers.TaskController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public  class PrioritisedTaskController extends TaskController{
    @FXML
    public Label priority;
    @Override
    public void viewTask(ActionEvent actionEvent) throws IOException {
        super.viewTask(actionEvent);
        LoadView.initializeView(this.Task,controller);
    }
}
