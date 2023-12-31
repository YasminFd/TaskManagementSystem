package com.example.demons.Controllers.TaskController;

import com.example.demons.DbConnection;
import com.example.demons.Decorator.DeadlineTaskDecorator;
import com.example.demons.Decorator.PrioritisedTaskDecorator;
import com.example.demons.Decorator.SuperViewTask;
import com.example.demons.enums.TaskStatus;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ViewTaskController extends TaskController {
    @FXML
    public HBox deadline_box, priority_box;
    @FXML
    public Label description,priority,deadline;
    @FXML
    public Hyperlink edit;

    //Decorator



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            System.out.println("Viewing:\n"+Task);
            //call decorator
            LoadView.initializeView(Task,this);
            //It is lambda expression on event listener
            //If Complete -> In Progress vice versa
            edit.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Are you sure you want to continue?");
                if(Task.getStatus()== TaskStatus.COMPLETED)
                alert.setContentText("Do you want to set Task as In Progress?");
                else{
                    alert.setContentText("Do you want to set Task as Completed?");
                }
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK){
                    if(Task.getStatus()==TaskStatus.COMPLETED){
                        System.out.println("Changing to in progress");
                        System.out.println(Task);
                        DbConnection db = DbConnection.getInstance();
                        db.editTaskStatus(Task.getID(), TaskStatus.IN_PROGRESS);
                        Task.setStatus(TaskStatus.IN_PROGRESS);
                        LoadView.initializeView(this.Task,this);

                    }
                    else{
                        System.out.println("Changing to completed");
                        System.out.println(Task);
                        DbConnection db = DbConnection.getInstance();
                        db.editTaskStatus(Task.getID(), TaskStatus.COMPLETED);
                        Task.setStatus(TaskStatus.COMPLETED);
                        //CALL METHOD TO CHOOSE APPROPIRIATE DECORATOR
                        LoadView.initializeView(this.Task,this);
                    }
                }
            });


        });
    }




}
