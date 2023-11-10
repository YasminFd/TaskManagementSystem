package com.example.demons.Controllers.TaskController;

import com.example.demons.LambdaInterfaces.StatusLambdaServices;
import com.example.demons.Models.Task;
import com.example.demons.enums.TaskStatus;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public abstract class TaskController  {
    @FXML
    public Label Title,status_text;
    @FXML
    public Pane status_color;
    @FXML
    public Hyperlink delete,view;
    public Task<?> Task;


    @FXML
    public  void viewTask(ActionEvent actionEvent){

    }
    @FXML
    public  void deleteTask(ActionEvent actionEvent) {

    }


    public void setTitle(String title) {
        Title.setText(title);
    }

    public void setStatus_text(TaskStatus status_text) {
        Platform.runLater(() -> {
            //dsiplay status text based on on tsk status enum
        this.status_text.setText(String.valueOf(status_text.getStatusText()));});
    }

    public void setStatus_color(TaskStatus status) {
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

    public void setTask(Task<?> task) {
        Task = task;
    }

}
