package com.example.demons.LambdaInterfaces;

import com.example.demons.Models.Task;

import java.util.ArrayList;

public interface GetTasks<T> {
    //single method interface to implement lambda expressions to get retrieve tasks
    public ArrayList<Task<T>> getAllTasks();
}
