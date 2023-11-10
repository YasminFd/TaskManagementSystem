package com.example.demons.Controllers.AddTaskController;

import com.example.demons.DbConnection;
import com.example.demons.Models.Task;
import com.example.demons.enums.TaskStatus;
import com.example.demons.enums.TaskType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ResourceBundle;

public class ChooseDeadlineController implements Initializable {
    private String title;
    private String description;
    private DbConnection dbConnection=DbConnection.getInstance();
    @FXML
    public Button add_deadline;
    @FXML
    public DatePicker deadline;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            add_deadline.setOnAction(event -> {
                LocalDate selectedDate = deadline.getValue();
                if (selectedDate != null) {
                    System.out.println("Selected Date: " + selectedDate);
                    Date d = Date.valueOf(selectedDate);
                    // You can do something with the selected date here
                    Task<Date> t = new Task<>(-1, TaskType.DEADLINE,title,description, TaskStatus.IN_PROGRESS,d,new java.util.Date());
                    try {
                       int id = dbConnection.addTask(t);
                       //Load View For Task with id
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("No date selected");
                }
            });
        })
        ;
    }
}
