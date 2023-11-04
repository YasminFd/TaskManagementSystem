package com.example.demons.Controllers.TaskController;

import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrioritisedTaskController extends TaskController{
    @FXML
    public Label priority;
    //public Task<PriorityStatus> Task;

    public void setPriority(PriorityStatus priorityTask) {
        Platform.runLater(() -> {
            if (priorityTask != null) {
                String p = priorityTask.getStatusText(); // Get the priority from the PriorityTask
                priority.setText(p);

                if (priorityTask == PriorityStatus.LOW) {
                    // Assuming "priority" is a Label, set its text and style
                    priority.setText("Low");
                    priority.setStyle("-fx-text-fill: green; -fx-font-weight: bold;"); // Set the text color to yellow
                } else if (priorityTask == PriorityStatus.MEDIUM) {
                    priority.setText("Low");
                    priority.setStyle("-fx-text-fill: yellow; -fx-font-weight: bold;");
                }
            } else {
                // Handle the case where the PriorityTask is null (if needed)
                priority.setText("N/A"); // Set an appropriate placeholder, e.g., "N/A"
            }
        });
    }


}
