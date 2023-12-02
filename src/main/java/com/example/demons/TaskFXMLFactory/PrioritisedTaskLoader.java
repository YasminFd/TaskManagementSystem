package com.example.demons.TaskFXMLFactory;

import com.example.demons.Controllers.TaskController.PrioritisedTaskController;
import com.example.demons.Decorator.PrioritisedTaskDecorator;
import com.example.demons.Decorator.SuperViewTask;
import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PrioritisedTaskLoader implements TaskFXMLLoader<PriorityStatus> {
    //Loads fxml of prioritised task type + set its properties
    @Override
    public VBox createTaskFXML(Task<PriorityStatus> task) throws IOException {
        SuperViewTask view= new PrioritisedTaskDecorator();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demons/Prioritised task.fxml"));
        VBox box = loader.load();
        PrioritisedTaskController controller = loader.getController();
        controller.setTask(task);
        view.setView(controller);
        return box;
    }
}
