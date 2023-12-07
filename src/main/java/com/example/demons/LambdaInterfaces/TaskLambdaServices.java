package com.example.demons.LambdaInterfaces;

import com.example.demons.DbConnection;

import java.sql.SQLException;
//interface implementing lambda expressions from GetTasks to get tasks of chosen type
public interface TaskLambdaServices {
    public DbConnection dbconn = DbConnection.getInstance();
    GetTasks getAll = ()->{
    //gets all tasks
        try {
            return dbconn.getAllTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
    GetTasks getToDoTasks = ()->{
    //gets tasks of type to do
        try {
            return dbconn.getAllNormalTask();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    GetTasks getPrioritisedTasks = ()->{
    //get tasks of type priority
        try {
            return dbconn.getAllPrioritisedTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    GetTasks getDeadlineTasks = ()->{
    // get tasks of type deadline
        try {
            return dbconn.getAllTimedTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
}
