package com.example.demons.Controllers;

import com.example.demons.Comparators.AllTasksComparator;
import com.example.demons.Controllers.AddTaskController.AddTaskController;
import com.example.demons.FilterStrategy.FilterDeadline;
import com.example.demons.FilterStrategy.FilterPriorities;
import com.example.demons.FilterStrategy.FilterTasks;
import com.example.demons.FilterStrategy.FilterToDo;
import com.example.demons.LambdaInterfaces.TaskLambdaServices;
import com.example.demons.Models.Task;
import com.example.demons.SortStrategy.*;
import com.example.demons.TaskFXMLFactory.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
//Controller for Home Page, Starter page of the whole application
public class StartController implements Initializable {
    @FXML
    public ImageView Logo,allTasks,addTask;
    @FXML
    public ChoiceBox<String>  filter;//to filter tasks based on type chosen
    @FXML
    public VBox Main;
    @FXML
    public ScrollPane scroll_pane;
    private ArrayList<Task> Tasks;
    @Override
    public void initialize(URL location, ResourceBundle resources) {//called as the fxml is loaded
        //get All tasks from DB by calling defined Lambda expression
        Tasks = TaskLambdaServices.getAll.getAllTasks();
        //sort ALl TAsks by Creation Date
        Collections.sort(Tasks,new AllTasksComparator());
        //Display The tasks
        Load_Screen();
    }

    public void goToHomePage(MouseEvent mouseEvent) {
        try {
            //return to main page with view of all tasks
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
            //switch the Vbox with id main with all tasks view to add task view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/add_task_main.fxml"));
            AnchorPane box = loader.load();
            List<Node> nodesToRemove = new ArrayList<>();
            for (Node node : Main.getChildren()) {
                if (node instanceof VBox || node instanceof HBox) {
                    nodesToRemove.add(node);
                }
            }
            //remove all controls on screen to change display to add a task
            Main.getChildren().removeAll(nodesToRemove);
            Main.getChildren().add(box);
            AddTaskController controller = loader.getController();

            FlowPane.setMargin(box, new Insets(10));/*
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/start.fxml"));
            Parent root = loader.load();
            //StartController controller = loader.getController();
            Scene scene = Logo.getScene();
            scene.setRoot(root);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void filter(ActionEvent actionEvent) {
        //when filter button is clicked calls this method to filter based to type chosen
        FilterTasks f ;//filter strategy
        SortTasks s;//sort strategy
        String selectedOption = filter.getValue();//get chosen value from menu
        //based on option ->get result
        if(selectedOption.equals("All Tasks")){
            //get type of tasks needed and sort respectively to each type
            Tasks=TaskLambdaServices.getAll.getAllTasks();
            s = new SortAllTasks();//choose strategy to use
            s.sort(Tasks);//apply sort
        }else if(selectedOption.equals("ToDo Tasks")){
            f= new FilterToDo();//choose filter to use
            s = new SortToDo();//choose strategy to use
            Tasks=f.filter();//apply filter
            s.sort(Tasks);//apply sort
        }else if(selectedOption.equals("Priorities")){
            f= new FilterPriorities();//choose filter to use
            s= new SortPriorities();//choose strategy to use
            Tasks=f.filter();//apply filter
            s.sort(Tasks);//apply sort
        } else if (selectedOption.equals("Deadlines")) {
            f= new FilterDeadline();//choose filter to use
            s= new SortDeadline();//choose strategy to use
            Tasks=f.filter();//apply filter
            s.sort(Tasks);//apply sort
        }
        System.out.println("Selected Option: " + selectedOption);
        Load_Screen();
    }
    private void Load_Screen(){
        Platform.runLater(() -> {
            scroll_pane.setFocusTraversable(true);
            Main.setFocusTraversable(false);
            filter.setFocusTraversable(false);
            //if there is any nodes remove to replace with new
            List<Node> nodesToRemove = new ArrayList<>();
            for (Node node : Main.getChildren()) {
                if (node instanceof VBox) {
                    nodesToRemove.add(node);
                }
            }
            Main.getChildren().removeAll(nodesToRemove);

            //sout tasks on terminal
            for (Task<?> R : Tasks)
                System.out.printf(R.toString());
            Insets margin = new Insets(30, 30, 15, 300);
            try {
                for (Task<?> R : Tasks) {


                    try {
                        TaskFXMLFactory taskFactory = new TaskFXMLFactory();//encapsulate the logic for creating task views of specific types
                        VBox taskView = taskFactory.Load_View(R.getType()).createTaskFXML(R);
                        VBox.setMargin(taskView, margin);
                        Main.getChildren().add(taskView);
                        FlowPane.setMargin(taskView, new Insets(10));
                    } catch (IOException e) {
                        e.printStackTrace(); // Handle the exception appropriately
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
