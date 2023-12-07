package com.example.demons.LambdaInterfaces;

import javafx.scene.Node;
//generic method as teh Status setter may take fxml components both have super class Node
public interface StatusSetter<T extends Node> {
    /*provide a concise and expressive way to define anonymous functions.
    They are beneficial for streamlining code, enhancing readability, and enabling
     functional programming constructs, making complex operations more succinct and
      maintainable. The use of lambda expressions often leads to cleaner, more
      efficient, and expressive code in a variety of scenarios.*/
    //single method interface to implement lambda
    // expressions to change display according to status
    void setStatus(T t);
    // generic parameters as we need to edit Pane and Label type
}
