package com.example.demons.Controllers.TaskController;

import com.example.demons.DbConnection;
import com.example.demons.LambdaInterfaces.StatusLambdaServices;
import com.example.demons.Models.Task;
import com.example.demons.enums.TaskStatus;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public abstract class TaskController implements Initializable {
    @FXML
    public VBox border;
    @FXML
    public Label Title,status_text;
    @FXML
    public Pane status_color;
    @FXML
    public Hyperlink delete,view;
    public Task<?> Task;

    public void initialize(URL location, ResourceBundle resources) {
        delete.setFocusTraversable(false);
        view.setFocusTraversable(false);
        border.setFocusTraversable(false);
    }
    @FXML
    public  void viewTask(ActionEvent actionEvent){

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
            //try {

                main.getChildren().remove(border);

            HBox p = (HBox) main.getParent();
            p.setFocusTraversable(false);
            //ScrollPane s = (ScrollPane) p.getParent();
            //s.setFocusTraversable(true);
            /*
            Stage previousStage = (Stage) Title.getScene().getWindow();

            // Close the previous stage
            previousStage.close();

            // Load and show the new stage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/start.fxml"));
            Parent startRoot = loader.load();
            Scene startScene = new Scene(startRoot);

            Stage newStage = new Stage(); // Create a new stage
            newStage.setTitle("TaDo");
            newStage.setScene(startScene);
            newStage.setMaximized(true); // Set the stage to be maximized
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }*/

            });}
    }


    public void setTitle(String title) {
        Title.setText(title);
    }

    public void setStatus_text(TaskStatus status_text) {
        Platform.runLater(() -> {
            //dsiplay status text based on on tsk status enum
        this.status_text.setText(String.valueOf(status_text.getStatusText()));});
    }

    public void setStatus_color(TaskStatus status) {
        Platform.runLater(() -> {
            //change display of status based on tasks enum status
            if (status == TaskStatus.COMPLETED) {
                StatusLambdaServices.setCompleted.setStatus(status_color);
            } else if (status == TaskStatus.IN_PROGRESS) {
                StatusLambdaServices.setInProgress.setStatus(status_color);
            }else if((status == TaskStatus.OVERDUE)){
                StatusLambdaServices.setOverDue.setStatus(status_color);
            }
        });
    }

    public void setTask(Task<?> task) {
        Task = task;
    }

}
