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

public class SuperViewTask implements ViewTaskDecorator{
    @Override
    public void setView(TaskController T) {
        System.out.println("Inside:\n"+T.getTask());
        setStatus_color(T.getTask().getStatus(),T.status_color);
        setStatus_text(T.getTask().getStatus(),T.status_text);
        T.setTitle(T.getTask().getTitle());
    }

    @Override
    public void setFullView(TaskController T) {
        System.out.println("Inside:\n"+T.getTask());
        setView(T);
        setBorder(T.getTask().getType(),T.getTask().getStatus() ,T.border);
        ViewTaskController t =(ViewTaskController) T;
        t.description.setText(t.getTask().getDescription());
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

        switch (T) {//depending on each type use the needed factory
            case ToDo:
                border.setStyle(border.getStyle()+"-fx-border-color: #8CC0DE;");
                break;
            case PRIORITISED:
                border.setStyle(border.getStyle()+"-fx-border-color: #EF9595;");
                break;
            case DEADLINE:
                if(status==TaskStatus.OVERDUE){
                    border.setStyle(border.getStyle()+"-fx-border-color: grey;");
                }
                else{
                    border.setStyle(border.getStyle()+"-fx-border-color: #8ACB88;");
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported task type");
        }
    }

}
