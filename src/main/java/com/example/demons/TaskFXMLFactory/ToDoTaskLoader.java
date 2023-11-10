package com.example.demons.TaskFXMLFactory;

import com.example.demons.Controllers.TaskController.NormalTaskController;
import com.example.demons.Models.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ToDoTaskLoader implements TaskFXMLLoader {
    //Loads fxml of To Do task type + set its properties
    @Override
    public VBox createTaskFXML(Task<?> task) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/Normal Task.fxml"));
        VBox box = loader.load();
        NormalTaskController controller = loader.getController();
        controller.setTask(task);
        controller.setTitle(task.getTitle());
        controller.setStatus_color(task.getStatus());
        controller.setStatus_text(task.getStatus());
        return box;
    }
}

