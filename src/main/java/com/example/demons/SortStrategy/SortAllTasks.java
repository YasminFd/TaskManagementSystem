package com.example.demons.SortStrategy;

import com.example.demons.Comparators.AllTasksComparator;
import com.example.demons.Models.Task;

import java.util.ArrayList;
import java.util.Collections;

public class SortAllTasks implements SortTasks{
    @Override
    public void sort(ArrayList<Task> T) {
        //sort all tasks using collections sort by creation of date
        Collections.sort(T, new AllTasksComparator());
        //used customised comparator
    }
}
