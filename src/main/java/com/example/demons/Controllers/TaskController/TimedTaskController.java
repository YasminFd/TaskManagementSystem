package com.example.demons.Controllers.TaskController;

import com.example.demons.enums.TaskStatus;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimedTaskController extends TaskController{
    @FXML
    public Label deadline;
    @FXML
    public VBox border;
    public void setDeadline(Date Deadline) {
        Platform.runLater(() -> {//display deadline by changing format
            if (Deadline != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define the desired date format
                String formattedDeadline = dateFormat.format(Deadline); // Format the date
                this.deadline.setText(formattedDeadline);
                if(Task.getStatus()==TaskStatus.OVERDUE){
                    border.setStyle(border.getStyle()+"-fx-border-color: grey;");
                    deadline.setStyle(deadline.getStyle()+"-fx-border-color: red;");
                }

            } else {
                // Handle the case where the deadline is null (if needed)
                this.deadline.setText("N/A");
                // Set an appropriate placeholder, e.g., "N/A"
            }
        });
    }



}
