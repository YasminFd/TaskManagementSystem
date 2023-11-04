package com.example.demons.Controllers.TaskController;

import com.example.demons.Models.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimedTaskController extends TaskController{
    @FXML
    public Label deadline;
    //public Task<Date> Task;

    public void setDeadline(Date deadline) {
        if (deadline != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define the desired date format
            String formattedDeadline = dateFormat.format(deadline); // Format the date
            this.deadline.setText(formattedDeadline); // Set the formatted date to the Label
        } else {
            // Handle the case where the deadline is null (if needed)
            this.deadline.setText("N/A"); // Set an appropriate placeholder, e.g., "N/A"
        }
    }

    public void setTask(com.example.demons.Models.Task<Date> task) {
        Task = task;
    }


}
