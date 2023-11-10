package com.example.demons.Controllers.TaskController;

import com.example.demons.DbConnection;
import com.example.demons.LambdaInterfaces.StatusLambdaServices;
import com.example.demons.Models.Task;
import com.example.demons.enums.TaskStatus;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

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
    public  void deleteTask(ActionEvent actionEvent) throws SQLException {
        DbConnection dbConnection=DbConnection.getInstance();
        int id=-1;
        System.out.println(Task.getID()+"?????");
        id= Task.getID();
        dbConnection.deleteTask(id);
        Platform.runLater(() -> {try {
            Stage previousStage = (Stage) Title.getScene().getWindow();

            // Close the previous stage
            previousStage.close();

            // Load and show the new stage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/start.fxml"));
            Parent startRoot = loader.load();
            Scene startScene = new Scene(startRoot);

            Stage newStage = new Stage(); // Create a new stage
            newStage.setTitle("TaDo");
            newStage.setScene(startScene);
            newStage.setMaximized(true); // Set the stage to be maximized
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }});
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
