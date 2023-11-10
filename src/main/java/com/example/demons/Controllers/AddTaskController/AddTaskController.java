package com.example.demons.Controllers.AddTaskController;

import com.example.demons.DbConnection;
import com.example.demons.Models.Task;
import com.example.demons.enums.TaskStatus;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
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
    private int flag=0;
    private String title,description;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/choose_type.fxml"));
                container_choose_type = loader.load();
                change.getChildren().add(container_choose_type);
                controller1 = loader.getController();
                // x.setAuthor_name(c.getUserNameFromId(x.getUser_id()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

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
                    if(type.equals("Deadline")){
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
                    }if(type.equals("Prioritised")){
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
                    Task<Date> t = new Task<>(-1,0,title,description, TaskStatus.IN_PROGRESS,null,new java.util.Date());
                    try {
                        dbConnection.addTask(t);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }






                    // controller = loader.getController();
                    // x.setAuthor_name(c.getUserNameFromId(x.getUser_id()));
                    /* controller.setData(x);
                    controller.setUser_id(this.user_id);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                //addReview.setVisible(false);*/


            });


        });
    }

}