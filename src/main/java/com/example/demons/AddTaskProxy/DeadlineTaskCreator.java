package com.example.demons.AddTaskProxy;

import java.sql.SQLException;
import java.util.Date;

public interface DeadlineTaskCreator {
    public int AddTask(String title, String description, Date deadline) throws Exception;
}
