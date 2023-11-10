package com.example.demons.Comparators;

import com.example.demons.Models.Task;

import java.util.Comparator;

public class AllTasksComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return o2.compareTo(o1);
    }
    //customised comparator based on compare to defined to Task Class
    //compare based on creation date
}
