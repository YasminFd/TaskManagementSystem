package com.example.demons.Controllers.TaskController;

import com.example.demons.DbConnection;
import com.example.demons.Models.Task;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public abstract class TaskController implements Initializable{
    @FXML
    public VBox border;
    @FXML
    public Label Title,status_text;
    @FXML
    public Circle status_color;
    @FXML
    public Hyperlink delete,view;

    public Task<?> Task;

    public void initialize(URL location, ResourceBundle resources) {
        delete.setFocusTraversable(false);
        view.setFocusTraversable(false);
        border.setFocusTraversable(false);
    }
    @FXML
    public  void viewTask(ActionEvent actionEvent) throws IOException {
        try {
            VBox Main = (VBox) border.getParent();
            //switch the Vbox with id main with all tasks view to task view of th clicked one
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/view.fxml"));
            VBox box = loader.load();
            List<Node> nodesToRemove = new ArrayList<>();
            for (Node node : Main.getChildren()) {
                if (node instanceof VBox || node instanceof HBox) {
                    nodesToRemove.add(node);
                }
            }
            //remove all controls on screen to change display to view Task
            Main.getChildren().removeAll(nodesToRemove);
            Main.getChildren().add(box);
            ViewTaskController controller = loader.getController();
            controller.setTask(this.Task);
            VBox.setMargin(box, new Insets(100,180,10,180));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public  void deleteTask(ActionEvent actionEvent) throws SQLException {
        VBox main = (VBox) border.getParent();
        main.setFocusTraversable(false);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to continue?");
        alert.setContentText("This action cannot be undone.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
        DbConnection dbConnection=DbConnection.getInstance();
        int id=-1;
        System.out.println(Task.getID()+"to be deleted");
        id= Task.getID();
        dbConnection.deleteTask(id);
        Platform.runLater(() -> {

                main.getChildren().remove(border);

            HBox p = (HBox) main.getParent();
            p.setFocusTraversable(false);

            });}
    }

    public void setTitle(String title) {
        Title.setText(title);
    }

    public void setTask(Task<?> task) {
        Task = task;
    }

    public Task getTask() {
        return Task;
    }
}
