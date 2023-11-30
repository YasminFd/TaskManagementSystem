package com.example.demons.Controllers.AddTaskController;

import com.example.demons.Controllers.TaskController.ViewTaskController;
import com.example.demons.DbConnection;
import com.example.demons.Decorator.SuperViewTask;
import com.example.demons.Models.Task;
import com.example.demons.enums.TaskStatus;
import com.example.demons.enums.TaskType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddTaskController implements Initializable {
    @FXML
    public Pane change;
    @FXML
    public Button action;
    @FXML
    public TextArea Description;
    @FXML
    public TextField Title;
    public ChooseTypeController controller1;
    public ChooseDeadlineController controller2;
    public ChoosePriorityController controller3;
    public AnchorPane container_choose_type;
    public AnchorPane container_choose_deadline;
    public AnchorPane container_choose_priority;
    @FXML
    public AnchorPane box;
    private DbConnection dbConnection=DbConnection.getInstance();

    private String title,description;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/choose_type.fxml"));
                container_choose_type = loader.load();
                change.getChildren().add(container_choose_type);
                controller1 = loader.getController();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Event listener lambda expression
            action.setOnAction(event -> {
                title=Title.getText().toString();
                description=Description.getText().toString();
                if(title.isEmpty() || description.isEmpty()){
                    Notifications notification = Notifications.create()
                            .title("Alert")
                            .text("Please Enter a value to search")
                            .hideAfter(Duration.seconds(3))
                            .position(Pos.TOP_CENTER);
                    notification.show();
                    return;
                }
                Title.setEditable(false);
                Description.setEditable(false);
                String type =controller1.getChosenButton();
                    if(type.equals("Deadline")){ //Load AddDeadline box
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/add_deadline.fxml"));
                        try {
                            container_choose_deadline = loader.load();
                            change.getChildren().remove(container_choose_type);
                            box.getChildren().remove(action);
                            change.getChildren().add(container_choose_deadline);
                            controller2 = loader.getController();
                            controller2.setTitle(title);
                            controller2.setDescription(description);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }if(type.equals("Prioritised")){ //Choose Priority
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/add_priority.fxml"));
                        try {
                            container_choose_priority = loader.load();
                            change.getChildren().remove(container_choose_type);
                            box.getChildren().remove(action);
                            change.getChildren().add(container_choose_priority);
                            controller3 = loader.getController();
                            controller3.setTitle(title);
                            controller3.setDescription(description);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }if(type.equals("ToDo")){
                    Task t = new Task<>(-1, TaskType.ToDo,title,description, TaskStatus.IN_PROGRESS,null,new java.util.Date());
                    //switch the Vbox with id main with all tasks view to task view of th clicked one

                    try {
                        int id = dbConnection.addTask(t);
                        t.setID(id);
                        VBox Main = (VBox) box.getParent();
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
                        VBox.setMargin(box,new Insets(50,100,10,180));
                        Main.getChildren().add(box);
                        ViewTaskController controller = loader.getController();
                        controller.setTask(t);
                        SuperViewTask s = new SuperViewTask();
                        s.setFullView(controller);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            });


        });
    }

}
