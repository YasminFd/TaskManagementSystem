package com.example.demons.FilterStrategy;

import com.example.demons.LambdaInterfaces.TaskLambdaServices;
import com.example.demons.Models.Task;
import com.example.demons.SortStrategy.SortDeadline;
import com.example.demons.SortStrategy.SortTasks;

import java.util.ArrayList;

public class FilterDeadline implements FilterTasks{
    @Override
    public ArrayList<Task> filter() {
        //called lambda expression to get all tasks of type deadline
        ArrayList<Task> Tasks= TaskLambdaServices.getDeadlineTasks.getAllTasks();
        SortTasks s= new SortDeadline();//choose strategy to use
        s.sort(Tasks);//apply sort
        return Tasks;
    }
}
