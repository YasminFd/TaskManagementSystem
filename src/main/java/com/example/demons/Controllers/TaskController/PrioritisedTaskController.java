package com.example.demons.Controllers.TaskController;

import com.example.demons.LambdaInterfaces.StatusLambdaServices;
import com.example.demons.enums.PriorityStatus;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrioritisedTaskController extends TaskController{
    @FXML
    public Label priority;


    public void setPriority(PriorityStatus priorityTask) {
        Platform.runLater(() -> {
            if (priorityTask != null) {
                String p = priorityTask.getStatusText(); // Get the priority from the PriorityTask
                priority.setText(p);
                //change the display of the priority based on its level by calling defined lambda expressions
                if (priorityTask == PriorityStatus.LOW) {
                    StatusLambdaServices.setLOW.setStatus(priority);
                    } else if (priorityTask == PriorityStatus.MEDIUM) {
                    StatusLambdaServices.setMEDIUM.setStatus(priority);
                    } else if(priorityTask == PriorityStatus.HIGH){
                    StatusLambdaServices.setHIGH.setStatus(priority);
                }
            } else {
                // Handle the case where the PriorityTask is null (if needed)
                priority.setText("N/A"); // Set an appropriate placeholder, e.g., "N/A"
            }
        });
    }


}
