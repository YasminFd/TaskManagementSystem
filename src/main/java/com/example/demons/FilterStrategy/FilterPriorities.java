package com.example.demons.FilterStrategy;

import com.example.demons.Comparators.PriorityTaskComparator;
import com.example.demons.LambdaInterfaces.TaskLambdaServices;
import com.example.demons.Models.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FilterPriorities implements FilterTasks{
    @Override
    public ArrayList<Task> filter() {
        ArrayList<Task> Tasks= TaskLambdaServices.getPrioritisedTasks.getAllTasks();
        Collections.sort(Tasks,new PriorityTaskComparator().reversed());
        return Tasks;
    }
}
