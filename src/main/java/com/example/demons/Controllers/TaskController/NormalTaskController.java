package com.example.demons.Controllers.TaskController;

import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;
import javafx.event.ActionEvent;

import java.util.Optional;

public class NormalTaskController extends TaskController{
    //public Task<?> Task;


    public void setTask() {
        setTask(null);
    }

    public void setTask(Task<?> task) {
        Task = task;
    }


}
