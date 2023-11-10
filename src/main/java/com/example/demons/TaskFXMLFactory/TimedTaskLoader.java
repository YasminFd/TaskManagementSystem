package com.example.demons.TaskFXMLFactory;

import com.example.demons.Controllers.TaskController.TimedTaskController;
import com.example.demons.Models.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Date;

public class TimedTaskLoader implements TaskFXMLLoader {
    //Loads fxml of deadline task type + set its properties
    @Override
    public VBox createTaskFXML(Task<?> task) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/Timed Task.fxml"));
        VBox box = loader.load();
        TimedTaskController controller = loader.getController();
        controller.setTask(task);
        controller.setDeadline((Date) task.getProperty());
        controller.setTitle(task.getTitle());
        controller.setStatus_color(task.getStatus());
        controller.setStatus_text(task.getStatus());
        return box;
    }
}
