package com.example.demons;

import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;
import com.example.demons.enums.TaskStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class DbConnection {

    private static DbConnection instance;
    private static Connection dbconn;

    private DbConnection() {
        String dbName = "taskmanager";
        String dbUser = "root";
        String dbPass = "";
        String url = "jdbc:mysql://127.0.0.1/" + dbName;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbconn = DriverManager.getConnection(url, dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public ArrayList<Task<?>> getAllTasks() throws SQLException {
        ArrayList<Task<?>> tasks = new ArrayList<>();

        PreparedStatement stmt = dbconn.prepareStatement("SELECT * FROM task");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int type = rs.getInt("type");
                int id = rs.getInt("id");
                String title = rs.getString("name");
                String description = rs.getString("description");
                TaskStatus status = TaskStatus.valueOf(rs.getString("status"));
                Date created_at = rs.getDate("created_at");

                if (type == 0) {
                    tasks.add(new Task<>(id,type, title, description, status, null, created_at));
                } else if (type == 1) {
                    PriorityStatus priority = PriorityStatus.valueOf(rs.getString("priority"));
                    tasks.add(new Task<>(id,type, title, description, status,  priority, created_at));
                } else if (type == 2) {
                    Date deadline = rs.getDate("deadline");
                    tasks.add(new Task<>(id,type, title, description, status, deadline, created_at));
                }
            }


        return tasks;
    }


}