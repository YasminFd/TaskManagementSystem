package com.example.demons.FilterStrategy;

import com.example.demons.LambdaInterfaces.TaskLambdaServices;
import com.example.demons.Models.Task;

import java.util.ArrayList;

public class FilterPriorities implements FilterTasks{
    @Override
    public ArrayList<Task> filter() {
        //called lambda expression to get all tasks of type priority
        ArrayList<Task> Tasks= TaskLambdaServices.getPrioritisedTasks.getAllTasks();
        return Tasks;
    }
}
