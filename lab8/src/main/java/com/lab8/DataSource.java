package com.lab8;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static BasicDataSource ds = new BasicDataSource();

    static {

        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("c3875d06L!");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }

    public static void closeConnection() throws SQLException {

        ds.close();
    }
}
