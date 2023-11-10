package com.example.demons.SortStrategy;

import com.example.demons.Comparators.NormalTaskComparator;
import com.example.demons.Models.Task;

import java.util.ArrayList;
import java.util.Collections;

public class SortToDo implements SortTasks{
    @Override
    public void sort(ArrayList<Task> T) {
    //sort To Do tasks using collections sort based on status In_progress before Completed
        Collections.sort(T,new NormalTaskComparator());
        //used customised comparator
    }
}
