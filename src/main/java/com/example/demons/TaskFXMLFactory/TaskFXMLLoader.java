package com.example.demons.TaskFXMLFactory;

import com.example.demons.Models.Task;
import javafx.scene.layout.VBox;

import java.io.IOException;

public abstract interface TaskFXMLLoader {
    //creation logic to be encapsulated
    public VBox createTaskFXML(Task<?> task) throws IOException;
}
