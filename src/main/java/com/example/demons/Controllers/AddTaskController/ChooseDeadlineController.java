package com.example.demons.Controllers.AddTaskController;

import com.example.demons.AddTaskProxy.TaskProxy;
import com.example.demons.DbConnection;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
            //lambda expression for event listener on button click
            add_deadline.setOnAction(event -> {
                LocalDate selectedDate = deadline.getValue();
                if (selectedDate != null) {
                    System.out.println("Selected Date: " + selectedDate);
                    Date d = Date.valueOf(selectedDate);
                    // You can do something with the selected date here
                    TaskProxy proxy= new TaskProxy();
                    try {
                        proxy.AddTask(title,description,d);
                    } catch (Exception e) {
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
