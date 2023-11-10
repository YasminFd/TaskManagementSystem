package com.example.demons.FilterStrategy;

import com.example.demons.LambdaInterfaces.TaskLambdaServices;
import com.example.demons.Models.Task;

import java.util.ArrayList;

public class FilterToDo implements FilterTasks{
    @Override
    public ArrayList<Task> filter() {
        //called lambda expression to get all tasks
        ArrayList<Task> Tasks= TaskLambdaServices.getToDoTasks.getAllTasks();
        return Tasks;
    }
}
