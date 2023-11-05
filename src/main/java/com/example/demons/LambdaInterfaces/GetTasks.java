package com.example.demons.LambdaInterfaces;

import com.example.demons.Models.Task;

import java.util.ArrayList;

public interface GetTasks<T> {
    public ArrayList<Task<T>> getAllTasks();
}
