package com.example.demons.Decorator;

import com.example.demons.Controllers.TaskController.TaskController;
import com.example.demons.Controllers.TaskController.ViewTaskController;
import com.example.demons.LambdaInterfaces.StatusLambdaServices;
import com.example.demons.enums.TaskStatus;
import com.example.demons.enums.TaskType;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class SuperViewTask<T extends TaskController> implements ViewTaskDecorator<T>{

    @Override
    public void setView(T c) {
        System.out.println("Inside:\n"+c.getTask());
        setStatus_color(c.getTask().getStatus(),c.status_color);
        setStatus_text(c.getTask().getStatus(),c.status_text);
        c.setTitle(c.getTask().getTitle());
    }


    @Override
    public void setFullView(TaskController t) {
        System.out.println("Inside:\n"+t.getTask());
        setStatus_color(t.getTask().getStatus(),t.status_color);
        setStatus_text(t.getTask().getStatus(),t.status_text);
        t.setTitle(t.getTask().getTitle());
        setBorder(t.getTask().getType(),t.getTask().getStatus() ,t.border);
        ViewTaskController T =(ViewTaskController) t;
        T.description.setText(t.getTask().getDescription());
    }

    @Override
    public void setStatus_text(TaskStatus status_text, Label status) {
        Platform.runLater(() -> {
            //dsiplay status text based on on tsk status enum
            status.setText(String.valueOf(status_text.getStatusText()));});
    }

    @Override
    public void setStatus_color(TaskStatus status, Circle status_color) {
        Platform.runLater(() -> {
            //change display of status based on tasks enum status
            if (status == TaskStatus.COMPLETED) {
                StatusLambdaServices.setCompleted.setStatus(status_color);
            } else if (status == TaskStatus.IN_PROGRESS) {
                StatusLambdaServices.setInProgress.setStatus(status_color);
            }else if((status == TaskStatus.OVERDUE)){
                StatusLambdaServices.setOverDue.setStatus(status_color);
            }
        });
    }
    @Override
    public void setBorder(TaskType T, TaskStatus status, VBox border) {

        String borderStyle = border.getStyle();

        switch (T) {
            case ToDo:
                // Adjusted shade for To Do type
                border.setStyle(borderStyle + "-fx-border-color: #6caad9;");
                break;
            case PRIORITISED:
                // Adjusted shade for PRIORITISED type
                border.setStyle(borderStyle + "-fx-border-color: #c16666;");
                break;
            case DEADLINE:
                if (status == TaskStatus.OVERDUE) {
                    // Adjusted shade for overdue tasks
                    border.setStyle(borderStyle + "-fx-border-color: grey;");
                } else {
                    // Adjusted shade for non-overdue tasks
                    border.setStyle(borderStyle + "-fx-border-color: #5b9862;");
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported task type");
        }
    }


}
