package com.example.demons.Decorator;

import com.example.demons.Controllers.TaskController.TaskController;
import com.example.demons.enums.TaskStatus;
import com.example.demons.enums.TaskType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public interface ViewTaskDecorator {
    public void setView(TaskController T);
    public void setFullView(TaskController T);
    public void setStatus_text(TaskStatus status_text, Label status);
    public void setStatus_color(TaskStatus status, Circle status_color);
    //public void setDeadline(Date Deadline, Label deadline, TaskStatus status);
    //public void setPriority(PriorityStatus priorityTask,Label priority);
    public void setBorder(TaskType T, TaskStatus status, VBox border);
}
