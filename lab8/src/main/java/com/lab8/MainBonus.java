package com.lab8;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainBonus {

    public static void main(String[] args) throws SQLException {

        Connection con = DataSource.getConnection();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        for (int i = 0; i <= 4; i++) {

            CityGenerator generator = new CityGenerator();
            executor.execute(generator);
        }

        executor.shutdown();
    }
}
