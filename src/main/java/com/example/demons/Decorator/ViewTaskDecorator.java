package com.example.demons.Decorator;

import com.example.demons.Controllers.TaskController.TaskController;
import com.example.demons.enums.TaskStatus;
import com.example.demons.enums.TaskType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public interface ViewTaskDecorator<T extends TaskController> {
    /*In our application we have different views, each based on what type o task we want to view as each
type has a unique property. However, in normal case of loading the view, we must set the text of the
title, the description, and the status as it is shared by all. But in case of deadline, we must also set
the deadline date, and as for that of prioritised task, we must also set the priority of the task. In
order to solve this conflict, decorator pattern is used to add or extend behaviour of the view loading
modifying the structure .
*/
    public void setView(T t );
    public void setFullView( TaskController t);
    public void setStatus_text(TaskStatus status_text, Label status);
    public void setStatus_color(TaskStatus status, Circle status_color);
    public void setBorder(TaskType T, TaskStatus status, VBox border);
}
