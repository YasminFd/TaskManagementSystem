package com.example.demons.SortStrategy;

import com.example.demons.Comparators.PriorityTaskComparator;
import com.example.demons.Models.Task;

import java.util.ArrayList;
import java.util.Collections;

public class SortPriorities implements SortTasks{
    @Override
    public void sort(ArrayList<Task> T) {
    //sort prioritised tasks using collections sort from High -> Medium -> Low
        Collections.sort(T,new PriorityTaskComparator().reversed());
        //used customised comparator
    }
}
