package com.example.demons.LambdaInterfaces;

import com.example.demons.DbConnection;

import java.sql.SQLException;

public interface TaskLambdaServices {
    public DbConnection dbconn = DbConnection.getInstance();
    public static GetTasks getAll = ()->{

        try {
            return dbconn.getAllTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
    public static GetTasks getToDoTasks = ()->{
        try {
            return dbconn.getAllNormalTask();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public static GetTasks getPrioritisedTasks = ()->{
        try {
            return dbconn.getAllPrioritisedTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public static GetTasks getDeadlineTasks = ()->{
        try {
            return dbconn.getAllTimedTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
}
