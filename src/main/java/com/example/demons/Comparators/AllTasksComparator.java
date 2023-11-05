package com.example.demons.Comparators;

import com.example.demons.Models.Task;

import java.util.Comparator;

public class AllTasksComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return o2.compareTo(o1);
    }
}
