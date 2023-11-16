package com.example.demons.Decorator;

import com.example.demons.Controllers.TaskController.PrioritisedTaskController;
import com.example.demons.Controllers.TaskController.TaskController;
import com.example.demons.Controllers.TaskController.ViewTaskController;
import com.example.demons.LambdaInterfaces.StatusLambdaServices;
import com.example.demons.enums.PriorityStatus;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class PrioritisedTaskDecorator extends SuperViewTask{
    @Override
    public void setView(TaskController T) {
        super.setView(T);
        if(T instanceof PrioritisedTaskController) {
            PrioritisedTaskController t = (PrioritisedTaskController) T;
            setPriority((PriorityStatus)t.getTask().getProperty(),t.priority);
            t.priority.setVisible(true);
        }

    }
    @Override
    public void setFullView(TaskController T) {

        if(T instanceof ViewTaskController){
            ViewTaskController t = (ViewTaskController) T;
            super.setFullView(t);
            t.priority_box.setVisible(true);
            setPriority((PriorityStatus) t.getTask().getProperty(),t.priority);
        }

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
