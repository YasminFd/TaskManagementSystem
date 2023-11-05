package com.example.demons.FilterStrategy;

import com.example.demons.Comparators.DeadlineTaskComparator;
import com.example.demons.LambdaInterfaces.TaskLambdaServices;
import com.example.demons.Models.Task;

import java.util.ArrayList;
import java.util.Collections;

public class FilterDeadline implements FilterTasks{
    @Override
    public ArrayList<Task> filter() {
        ArrayList<Task> Tasks= TaskLambdaServices.getDeadlineTasks.getAllTasks();
        Collections.sort(Tasks, new DeadlineTaskComparator());
        return Tasks;
    }
}
