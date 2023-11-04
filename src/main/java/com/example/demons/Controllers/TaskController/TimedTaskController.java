package com.example.demons.Controllers.TaskController;

import com.example.demons.Models.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Date;

public class TimedTaskController extends TaskController{
    @FXML
    public Label deadline;
    public Task<Date> Task;
}
