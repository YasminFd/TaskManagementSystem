package com.example.demons.Controllers.AddTaskController;

import com.example.demons.Controllers.TaskController.ViewTaskController;
import com.example.demons.DbConnection;
import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;
import com.example.demons.enums.TaskStatus;
import com.example.demons.enums.TaskType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    @FXML
    public AnchorPane pane;

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
                    t.setID(id);
                    VBox Main = (VBox) pane.getParent().getParent().getParent();
                    //switch the Vbox with id main with all tasks view to task view of th clicked one
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/view.fxml"));
                    VBox box = loader.load();
                    List<Node> nodesToRemove = new ArrayList<>();
                    for (Node node : Main.getChildren()) {
                        if (node instanceof AnchorPane || node instanceof VBox) {
                            nodesToRemove.add(node);
                        }
                    }
                    //remove all controls on screen to change display to view Task
                    Main.getChildren().removeAll(nodesToRemove);
                    Main.getChildren().add(box);
                    ViewTaskController controller = loader.getController();
                    System.out.println(t);
                    controller.setTask(t);

                    //Load View For Task with id
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
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
