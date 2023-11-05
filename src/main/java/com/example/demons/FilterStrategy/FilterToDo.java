package com.example.demons.FilterStrategy;

import com.example.demons.Comparators.NormalTaskComparator;
import com.example.demons.Comparators.PriorityTaskComparator;
import com.example.demons.LambdaInterfaces.TaskLambdaServices;
import com.example.demons.Models.Task;

import java.util.ArrayList;
import java.util.Collections;

public class FilterToDo implements FilterTasks{
    @Override
    public ArrayList<Task> filter() {
        ArrayList<Task> Tasks= TaskLambdaServices.getToDoTasks.getAllTasks();
        Collections.sort(Tasks,new NormalTaskComparator());
        return Tasks;
    }
}
