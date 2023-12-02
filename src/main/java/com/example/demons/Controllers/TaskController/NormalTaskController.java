package com.example.demons.Controllers.TaskController;

import javafx.event.ActionEvent;

import java.io.IOException;

public class NormalTaskController extends TaskController{

    @Override
    public void viewTask(ActionEvent actionEvent) throws IOException {
        super.viewTask(actionEvent);
        LoadView.initializeView(this.Task,controller);
    }
}
