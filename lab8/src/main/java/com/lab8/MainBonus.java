package com.lab8;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainBonus {

    public static void main(String[] args) throws SQLException {

        Connection con = DataSource.getConnection();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        for (int i = 1; i <= 5; i++) {

            CityGenerator generator = new CityGenerator();
            executor.execute(generator);
        }

        executor.shutdown();
    }
}
