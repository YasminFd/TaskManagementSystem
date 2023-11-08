package com.example.demons.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseTypeController {

    @FXML
    private RadioButton PriorityRadio;

    @FXML
    private RadioButton ToDoRadio;

    @FXML
    private RadioButton DeadlineRadio;

    @FXML
    private ToggleGroup grp;
    public void initialize() {
        ToDoRadio.setToggleGroup(grp);
        PriorityRadio.setToggleGroup(grp);
        DeadlineRadio.setToggleGroup(grp);

        // You can add a listener to perform an action when a RadioButton is selected.
        grp.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                System.out.println("Selected RadioButton: " + selectedRadioButton.getText());
            }
        });

    }
public String getChosenButton(){
    RadioButton selectedRadioButton = (RadioButton) grp.getSelectedToggle();
    String toogleGroupValue = selectedRadioButton.getText();
    return toogleGroupValue;
}
/*
    public void goToPriority(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show(); // You need to show the new scene.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToDeadline(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewDeadline.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show(); // You need to show the new scene.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
