package com.example.demons.SortStrategy;

import com.example.demons.Comparators.DeadlineTaskComparator;
import com.example.demons.Models.Task;

import java.util.ArrayList;
import java.util.Collections;

public class SortDeadline implements SortTasks{
    @Override
    public void sort(ArrayList<Task> T) {
        //sort deadline tasks using collections starting from earliest deadline
        Collections.sort(T, new DeadlineTaskComparator());
        //used customised comparator
    }
}
