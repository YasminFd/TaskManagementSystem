package com.example.demons.Controllers.TaskController;

import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrioritisedTaskController extends TaskController{
    @FXML
    public Label priority;
    public Task<PriorityStatus> Task;
}
