package com.example.demons.TaskFXMLFactory;

import com.example.demons.Controllers.TaskController.TimedTaskController;
import com.example.demons.Decorator.DeadlineTaskDecorator;
import com.example.demons.Decorator.SuperViewTask;
import com.example.demons.Models.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TimedTaskLoader implements TaskFXMLLoader {
    //Loads fxml of deadline task type + set its properties
    @Override
    public VBox createTaskFXML(Task<?> task) throws IOException {
        SuperViewTask view= new DeadlineTaskDecorator();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/Timed Task.fxml"));
        VBox box = loader.load();
        TimedTaskController controller = loader.getController();
        controller.setTask(task);
        view.setView(controller);
        return box;
    }
}
