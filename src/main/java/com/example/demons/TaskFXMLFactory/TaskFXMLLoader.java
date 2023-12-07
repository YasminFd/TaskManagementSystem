package com.example.demons.TaskFXMLFactory;

import com.example.demons.Models.Task;
import javafx.scene.layout.VBox;

import java.io.IOException;

public abstract interface TaskFXMLLoader<T> {
    //creation logic to be encapsulated
    public VBox createTaskFXML(Task<T> task) throws IOException;
}
