package com.example.demons;

import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;
import com.example.demons.enums.TaskStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;

public class DbConnection {

    private static DbConnection instance;
    private static Connection dbconn;
    private Predicate<java.util.Date> dateHasPassed = (date) -> date.before(new java.util.Date());

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

    public ArrayList<Task> getAllTasks() throws SQLException {
        ArrayList<Task> tasks = new ArrayList<>();

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
                tasks.add(new Task<>(id, type, title, description, status, null, created_at));
            } else if (type == 1) {
                PriorityStatus priority = PriorityStatus.valueOf(rs.getString("priority"));
                tasks.add(new Task<>(id, type, title, description, status, priority, created_at));
            } else if (type == 2) {
                Date deadline = rs.getDate("deadline");
                if(dateHasPassed.test(deadline) && status!=TaskStatus.COMPLETED && status!=TaskStatus.OVERDUE)
                {
                    status=TaskStatus.OVERDUE;
                    editTaskStatus(id,TaskStatus.OVERDUE);
                }
                tasks.add(new Task<>(id, type, title, description, status, deadline, created_at));
            }
        }


        return tasks;
    }

    public ArrayList<Task> getAllNormalTask() throws SQLException {
        ArrayList<Task> tasks = new ArrayList<>();

        PreparedStatement stmt = dbconn.prepareStatement("SELECT * FROM task WHERE type=?");

            stmt.setInt(1,0 );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int type = rs.getInt("type");
            int id = rs.getInt("id");
            String title = rs.getString("name");
            String description = rs.getString("description");
            TaskStatus status = TaskStatus.valueOf(rs.getString("status"));
            Date created_at = rs.getDate("created_at");

                tasks.add(new Task<>(id, type, title, description, status, null, created_at));

        }


        return tasks;
    }
    public ArrayList<Task> getAllPrioritisedTasks() throws SQLException {
        ArrayList<Task> tasks = new ArrayList<>();

        PreparedStatement stmt = dbconn.prepareStatement("SELECT * FROM task WHERE type=?");

        stmt.setInt(1,1 );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int type = rs.getInt("type");
            int id = rs.getInt("id");
            String title = rs.getString("name");
            String description = rs.getString("description");
            TaskStatus status = TaskStatus.valueOf(rs.getString("status"));
            Date created_at = rs.getDate("created_at");

                PriorityStatus priority = PriorityStatus.valueOf(rs.getString("priority"));
                tasks.add(new Task<>(id, type, title, description, status, priority, created_at));
        }


        return tasks;
    }

    public ArrayList<Task> getAllTimedTasks() throws SQLException {
        ArrayList<Task> tasks = new ArrayList<>();

        PreparedStatement stmt = dbconn.prepareStatement("SELECT * FROM task WHERE type=?");

        stmt.setInt(1,2 );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int type = rs.getInt("type");
            int id = rs.getInt("id");
            String title = rs.getString("name");
            String description = rs.getString("description");
            TaskStatus status = TaskStatus.valueOf(rs.getString("status"));
            Date created_at = rs.getDate("created_at");

            Date deadline = rs.getDate("deadline");
            if(dateHasPassed.test(deadline) && status!=TaskStatus.COMPLETED && status!=TaskStatus.OVERDUE)
            {
                status=TaskStatus.OVERDUE;
                editTaskStatus(id,TaskStatus.OVERDUE);
            }
            tasks.add(new Task<>(id, type, title, description, status, deadline, created_at));
        }


        return tasks;
    }
    public void editTaskStatus(int ID, TaskStatus T) {
        String updateStatusSQL = "UPDATE task SET status=? WHERE id=?";
        try (PreparedStatement stmt = dbconn.prepareStatement(updateStatusSQL)) {
            stmt.setInt(1, ID);
            stmt.setString(2, T.getStatusText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int addTask(Task task) throws SQLException {
        String insertQuery;

        int type = task.getType();
        String title = task.getTitle();
        String description = task.getDescription();
        TaskStatus status = task.getStatus();
        Date created_at = task.getCreated_at();
        PriorityStatus priority = null;
        Date deadline = null;

        // Depending on the task type, prepare the INSERT query
        if (type == 0) {
            insertQuery = "INSERT INTO task (type, name, description, status, created_at) VALUES (?, ?, ?, ?, ?)";
        } else if (type == 1) {
            priority = (PriorityStatus) task.getProperty();
            insertQuery = "INSERT INTO task (type, name, description, status, priority, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        } else if (type == 2) {
            deadline = (Date)task.getProperty();
            insertQuery = "INSERT INTO task (type, name, description, status, deadline, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        } else {
            // Handle unsupported task type
            throw new IllegalArgumentException("Unsupported task type");
        }

        try (PreparedStatement stmt = dbconn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, type);
            stmt.setString(2, title);
            stmt.setString(3, description);
            stmt.setString(4, status.name());
            if (type == 1) {
                stmt.setString(5, priority.name());
                stmt.setDate(6, new java.sql.Date(created_at.getTime()));
            } else if (type == 2) {
                stmt.setDate(5, new java.sql.Date(deadline.getTime()));
                stmt.setDate(6, new java.sql.Date(created_at.getTime()));
            } else {
                stmt.setDate(5, new java.sql.Date(created_at.getTime()));
            }

            // Execute the INSERT query
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                // Retrieve the generated ID
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        System.out.println("Generated ID: " + generatedId);
                        return generatedId;
                        // You can now use the generatedId as needed
                    } else {
                        throw new SQLException("Failed to retrieve generated ID");
                    }
                }
            } else {
                throw new SQLException("Failed to insert task, no rows affected");
            }
        }

    }
}