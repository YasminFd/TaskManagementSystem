package com.example.demons.TaskFXMLFactory;

import com.example.demons.Controllers.TaskController.PrioritisedTaskController;
import com.example.demons.Models.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import com.example.demons.enums.PriorityStatus;

import java.io.IOException;

public class PrioritisedTaskLoader implements TaskFXMLLoader {
    //Loads fxml of prioritised task type + set its properties
    @Override
    public VBox createTaskFXML(Task<?> task) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/Prioritised task.fxml"));
        VBox box = loader.load();
        PrioritisedTaskController controller = loader.getController();
        controller.setTask(task);
        controller.setPriority((PriorityStatus)task.getProperty());
        controller.setTitle(task.getTitle());
        controller.setStatus_color(task.getStatus());
        controller.setStatus_text(task.getStatus());
        return box;
    }
}
