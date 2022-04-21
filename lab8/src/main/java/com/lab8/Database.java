package com.lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/countries";
    private static final String USER = "postgres";
    private static final String PASSWORD = "c3875d06L!";
    private static Connection connection = null;

    private Database() {}

    public static Connection getConnection() {

        return connection;
    }

    private static void createConnection() {
        try {

            connection = DriverManager.getConnection(URL);
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {

            System.err.println(e);
        }
    }

    public static void closeConnection() {

        try {

            connection.close();
        }
        catch (SQLException e) {

            System.err.println(e);
        }
    }
}