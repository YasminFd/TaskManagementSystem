package com.example.demons;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private static DbConnection instance;
    private static Connection dbconn;

    private DbConnection() {
        String dbName = "gui";
        String dbUser = "root";
        String dbPass = "";
        String url = "jdbc:mysql://127.0.0.1/" + dbName;

        try {
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
}
