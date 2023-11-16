package com.example.demons.Controllers.TaskController;

import com.example.demons.DbConnection;
import com.example.demons.Decorator.DeadlineTaskDecorator;
import com.example.demons.Decorator.PrioritisedTaskDecorator;
import com.example.demons.Decorator.SuperViewTask;
import com.example.demons.enums.TaskStatus;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ViewTaskController extends TaskController implements Initializable {
    @FXML
    public HBox deadline_box, priority_box;
    @FXML
    public Label description,priority,deadline;
    @FXML
    public Hyperlink edit;
    //@FXML
    //public Circle status_color;
    //private Task Task;
    SuperViewTask view ;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            System.out.println("Viewing:\n"+Task);
            initializeView();
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
                        initializeView();

                    }
                    else{
                        System.out.println("Changing to completed");
                        System.out.println(Task);
                        DbConnection db = DbConnection.getInstance();
                        db.editTaskStatus(Task.getID(), TaskStatus.COMPLETED);
                        Task.setStatus(TaskStatus.COMPLETED);
                        initializeView();
                    }
                }
            });


        });
    }
    private void initializeView() {
        System.out.println("Viewing:\n" + Task);
        switch (Task.getType()) {
            case ToDo:
                view = new SuperViewTask();
                view.setFullView(this);
                break;
            case PRIORITISED:
                view = new PrioritisedTaskDecorator();
                view.setFullView(this);
                break;
            case DEADLINE:
                view = new DeadlineTaskDecorator();
                view.setFullView(this);
                break;
            default:
                throw new IllegalArgumentException("Unsupported task type");
        }
    }

}
