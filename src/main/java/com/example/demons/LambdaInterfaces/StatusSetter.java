package com.example.demons.LambdaInterfaces;

public interface StatusSetter<T> {
    //single method interface to implement lambda
    // expressions to change display according to status
    public void setStatus(T t);
    // generic parameters as we need to edit Pane and Label type
}
