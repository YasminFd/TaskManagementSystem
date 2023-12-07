package com.example.demons.AddTaskProxy;

import java.sql.SQLException;
import java.util.Date;

public interface DeadlineTaskCreator {
    /*The user has the ability to add new tasks of different types of tasks, one of which is a deadline task
characterised with the definition of a deadline date which help him track deadlines effectively.
However, it is kind of logical that the user shouldn’t add a deadline that has already passed, as it is a
waste of space in the database. For that Proxy pattern is needed to add a layer of protection by
creating first a Proxy Deadline Task, checks if deadline is approved before proceeding with the
creation of the real task and save it in database*/
    public int AddTask(String title, String description, Date deadline) throws Exception;
}
