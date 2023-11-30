package com.example.demons.Controllers.AddTaskController;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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
}
