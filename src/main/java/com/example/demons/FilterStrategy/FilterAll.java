package com.example.demons.FilterStrategy;

import com.example.demons.LambdaInterfaces.TaskLambdaServices;
import com.example.demons.Models.Task;
import com.example.demons.SortStrategy.SortAllTasks;
import com.example.demons.SortStrategy.SortTasks;

import java.util.ArrayList;

public class FilterAll implements FilterTasks{
    @Override
    public ArrayList<Task> filter() {
        ArrayList<Task> Tasks= TaskLambdaServices.getAll.getAllTasks();
        //sort by creation date
        SortTasks s = new SortAllTasks();//choose strategy to use
        s.sort(Tasks);
        return Tasks;
    }
}
