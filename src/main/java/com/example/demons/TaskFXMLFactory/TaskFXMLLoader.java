package com.example.demons.TaskFXMLFactory;

import com.example.demons.Models.Task;
import javafx.scene.layout.VBox;

import java.io.IOException;

public interface TaskFXMLLoader {
    /*TaskFactory uses the Factory Design Pattern, providing a structured approach
     for creating instances of different UI components based on the type of tasks.
      defines a contract for creating task views, and concrete implementations
      (ToDoTaskFactory, PrioritisedTaskFactory, TimedTaskFactory)
      encapsulate the logic for creating task views of specific types such as loading there perspective
       FXML and setting each of their unique properties*/
    public VBox createTaskFXML(Task<?> task) throws IOException;
}
