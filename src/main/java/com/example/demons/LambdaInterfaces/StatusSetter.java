package com.example.demons.LambdaInterfaces;

import javafx.scene.Node;

public interface StatusSetter<T extends Node> {
    //single method interface to implement lambda
    // expressions to change display according to status
    void setStatus(T t);
    // generic parameters as we need to edit Pane and Label type
}
