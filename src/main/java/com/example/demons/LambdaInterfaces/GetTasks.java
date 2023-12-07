package com.example.demons.LambdaInterfaces;

import com.example.demons.Models.Task;

import java.util.ArrayList;
//generic as the method returns Array list of generic Tasks: either priority property or deadline or nothing
public interface GetTasks<T> {
    /*provide a concise and expressive way to define anonymous functions.
    They are beneficial for streamlining code, enhancing readability, and enabling
     functional programming constructs, making complex operations more succinct and
      maintainable. The use of lambda expressions often leads to cleaner, more
      efficient, and expressive code in a variety of scenarios.*/
    //single method interface to implement lambda expressions to get retrieve tasks
    ArrayList<Task<T>> getAllTasks();
}
