package com.lab9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "c3875d06L!";
    private static Connection connection = null;

    private Database() {}

    public static Connection getConnection() {

        if (connection == null) {

            createConnection();
        }

        return connection;
    }

    private static void createConnection() {

        try {

            Properties properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);

            connection = DriverManager.getConnection(URL, properties);
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void closeConnection() {

        try {

            connection.close();
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
    }
}