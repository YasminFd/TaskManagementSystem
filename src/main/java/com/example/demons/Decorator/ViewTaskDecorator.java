package com.example.demons.Decorator;

import com.example.demons.Controllers.TaskController.TaskController;
import com.example.demons.enums.TaskStatus;
import com.example.demons.enums.TaskType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public interface ViewTaskDecorator<T extends TaskController, U extends TaskController> {
    public void setView(T t );
    public void setFullView( U t);
    public void setStatus_text(TaskStatus status_text, Label status);
    public void setStatus_color(TaskStatus status, Circle status_color);
    public void setBorder(TaskType T, TaskStatus status, VBox border);
}
