package com.example.demons.Decorator;

import com.example.demons.Controllers.TaskController.PrioritisedTaskController;
import com.example.demons.Controllers.TaskController.TaskController;
import com.example.demons.Controllers.TaskController.ViewTaskController;
import com.example.demons.LambdaInterfaces.StatusLambdaServices;
import com.example.demons.enums.PriorityStatus;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class PrioritisedTaskDecorator extends SuperViewTask<PrioritisedTaskController,ViewTaskController>{
    @Override
    public void setView(PrioritisedTaskController T) {
        super.setView(T);
            setPriority((PriorityStatus)T.getTask().getProperty(), T.priority);
            T.priority.setVisible(true);


    }
    @Override
    public void setFullView(ViewTaskController T) {
            super.setFullView(T);
            T.priority_box.setVisible(true);
            setPriority((PriorityStatus) T.getTask().getProperty(),T.priority);
    }

    public void setPriority(PriorityStatus priorityTask, Label priority) {

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
