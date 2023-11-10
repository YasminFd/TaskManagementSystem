package com.example.demons.TaskFXMLFactory;

import com.example.demons.Models.Task;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TaskFXMLFactory{
    private TaskFXMLLoader taskFactory;
    public VBox Load_View(Task T) throws IOException {
        /*TaskFactory uses the Factory Design Pattern, providing a structured approach
     for creating instances of different UI components based on the type of tasks.
      defines a contract for creating task views, and concrete implementations
      (ToDoTaskFactory, PrioritisedTaskFactory, TimedTaskFactory)
      encapsulate the logic for creating task views of specific types such as loading there perspective
       FXML and setting each of their unique properties*/
        switch (T.getType()) {//depending on each type use the needed factory
            case ToDo:
                taskFactory = new ToDoTaskLoader();
                break;
            case PRIORITISED:
                taskFactory = new PrioritisedTaskLoader();
                break;
            case DEADLINE:
                taskFactory = new TimedTaskLoader();
                break;
            default:
                throw new IllegalArgumentException("Unsupported task type");
        }
        return taskFactory.createTaskFXML(T);
    }
}
