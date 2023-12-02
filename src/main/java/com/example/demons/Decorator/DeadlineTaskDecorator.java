package com.example.demons.Decorator;

import com.example.demons.Controllers.TaskController.PrioritisedTaskController;
import com.example.demons.Controllers.TaskController.TaskController;
import com.example.demons.Controllers.TaskController.TimedTaskController;
import com.example.demons.Controllers.TaskController.ViewTaskController;
import com.example.demons.enums.PriorityStatus;
import com.example.demons.enums.TaskStatus;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DeadlineTaskDecorator extends SuperViewTask<TimedTaskController>{
    @Override
    public void setView(TimedTaskController T) {
        super.setView(T);
        setDeadline((Date) T.getTask().getProperty(),T.deadline,T.getTask().getStatus());
    }

    @Override
    public void setFullView(TaskController T) {
        if(T instanceof ViewTaskController){
            ViewTaskController t = (ViewTaskController) T;
            super.setFullView(t);
            if(t.getTask().getStatus()==TaskStatus.OVERDUE){
                t.edit.setVisible(false);
            }
            t.deadline_box.setVisible(true);
            setDeadline((Date) t.getTask().getProperty(),t.deadline,t.getTask().getStatus());
        }
    }


    public void setDeadline(Date Deadline, Label deadline, TaskStatus status) {
        Platform.runLater(() -> {//display deadline by changing format
            if (Deadline != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define the desired date format
                String formattedDeadline = dateFormat.format(Deadline); // Format the date
                deadline.setText(formattedDeadline);
                if(status==TaskStatus.OVERDUE){
                    deadline.setStyle(deadline.getStyle()+"-fx-border-color: red;");
                }

            } else {
                // Handle the case where the deadline is null (if needed)
                deadline.setText("N/A");
                // Set an appropriate placeholder, e.g., "N/A"
            }
        });
    }
}
