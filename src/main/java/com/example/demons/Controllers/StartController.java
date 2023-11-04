package com.example.demons.Controllers;
import com.example.demons.Controllers.TaskController.NormalTaskController;
import com.example.demons.Controllers.TaskController.PrioritisedTaskController;
import com.example.demons.Controllers.TaskController.TimedTaskController;
import com.example.demons.DbConnection;
import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class StartController implements Initializable {
    @FXML
    public ImageView Logo,allTasks,addTask;
    @FXML
    public ChoiceBox<String>  filter;
    @FXML
    public VBox Main;
    @FXML
    public ScrollPane scroll_pane;
    private ArrayList<Task<?>> Tasks;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {

            scroll_pane.setFocusTraversable(true);
            Main.setFocusTraversable(false);
            filter.setFocusTraversable(false);
            List<Node> nodesToRemove = new ArrayList<>();
            for (Node node : Main.getChildren()) {
                if (node instanceof VBox) {
                    nodesToRemove.add(node);
                }
            }
            Main.getChildren().removeAll(nodesToRemove);

            filter.setValue("All Tasks");

            try {
                Tasks=getTasks();
                for (Task<?> R : Tasks)
                    System.out.printf(R.toString());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Insets margin = new Insets(30, 30, 15, 300);
            try {
                for (Task<?> R : Tasks) {

                    if(R.getType()==0) {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/Normal Task.fxml"));
                        VBox box = loader.load();
                        NormalTaskController controller = loader.getController();
                        controller.setTask(R);
                        controller.setTitle(R.getTitle());
                        controller.setStatus_color(R.getStatus());
                        controller.setStatus_text(R.getStatus());
                        VBox.setMargin(box, margin);
                        Main.getChildren().add(box);
                        FlowPane.setMargin(box, new Insets(10));
                    }else if(R.getType()==1){
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/Prioritised task.fxml"));
                        VBox box = loader.load();
                        PrioritisedTaskController controller = loader.getController();
                        controller.setTask(R);
                        controller.setPriority((PriorityStatus)R.getProperty());
                        controller.setTitle(R.getTitle());
                        controller.setStatus_color(R.getStatus());
                        controller.setStatus_text(R.getStatus());
                        VBox.setMargin(box, margin);
                        Main.getChildren().add(box);
                        FlowPane.setMargin(box, new Insets(10));
                    }else{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/Timed Task.fxml"));
                        VBox box = loader.load();
                        TimedTaskController controller = loader.getController();
                        controller.setTask(R);
                        controller.setDeadline((Date)R.getProperty());
                        controller.setTitle(R.getTitle());
                        controller.setStatus_color(R.getStatus());
                        controller.setStatus_text(R.getStatus());
                        VBox.setMargin(box, margin);
                        Main.getChildren().add(box);
                        FlowPane.setMargin(box, new Insets(10));
                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public void goToHomePage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/start.fxml"));
            Parent root = loader.load();
            //StartController controller = loader.getController();
            Scene scene = Logo.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void goToAddTask(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/start.fxml"));
            Parent root = loader.load();
            //StartController controller = loader.getController();
            Scene scene = Logo.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Task<?>> getTasks() throws SQLException {
        DbConnection dbconn = DbConnection.getInstance();
        return dbconn.getAllTasks();
    }

}
