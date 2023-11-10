package com.example.demons.Controllers.AddTaskController;

import com.example.demons.DbConnection;
import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;
import com.example.demons.enums.TaskStatus;
import com.example.demons.enums.TaskType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class ChoosePriorityController implements Initializable {
    private String title;
    private String description;
    private DbConnection dbConnection=DbConnection.getInstance();
    @FXML
    public Button add_priority;
    @FXML
    private RadioButton lowRadioButton;

    @FXML
    private RadioButton mediumRadioButton;

    @FXML
    private RadioButton highRadioButton;

    @FXML
    private ToggleGroup grp;

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
            add_priority.setOnAction(event -> {
                String chosenButton = getChosenButton();
                PriorityStatus p = PriorityStatus.fromString(chosenButton);
                Task<PriorityStatus> t = new Task<>(-1, TaskType.PRIORITISED,title,description, TaskStatus.IN_PROGRESS,p,new Date());
                try {
                    int id = dbConnection.addTask(t);
                    //Load View For Task with id
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }
    public String getChosenButton(){
        RadioButton selectedRadioButton = (RadioButton) grp.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        return toogleGroupValue;
    }
}
