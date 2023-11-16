package com.example.demons.Controllers.AddTaskController;

import com.example.demons.AddTaskProxy.TaskProxy;
import com.example.demons.Controllers.TaskController.ViewTaskController;
import com.example.demons.DbConnection;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChooseDeadlineController implements Initializable {
    private String title;
    private String description;
    private DbConnection dbConnection=DbConnection.getInstance();
    @FXML
    public Button add_deadline;
    @FXML
    public DatePicker deadline;
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
            add_deadline.setOnAction(event -> {
                LocalDate selectedDate = deadline.getValue();
                if (selectedDate != null) {
                    System.out.println("Selected Date: " + selectedDate);
                    Date d = Date.valueOf(selectedDate);
                    // You can do something with the selected date here
                    TaskProxy proxy= new TaskProxy();
                    try {
                        int id = proxy.AddTask(title,description,d);
                        VBox Main = (VBox) pane.getParent().getParent().getParent();
                        //switch the Vbox with id main with all tasks view to task view of th clicked one
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/view.fxml"));
                        VBox bol = loader.load();
                        List<Node> nodesToRemove = new ArrayList<>();
                        for (Node node : Main.getChildren()) {
                            if (node instanceof AnchorPane || node instanceof VBox) {
                                nodesToRemove.add(node);
                            }
                        }
                        //remove all controls on screen to change display to view Task
                        Main.getChildren().removeAll(nodesToRemove);
                        Main.getChildren().add(bol);
                        ViewTaskController controller = loader.getController();
                        proxy.getRealTask().setID(id);
                        controller.setTask(proxy.getRealTask());

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
