package com.lab8;

import com.github.javafaker.Faker;

import java.sql.SQLException;

public class CityGenerator implements Runnable {

    private Faker faker;

    public CityGenerator() {

        this.faker = new Faker();
    }

    @Override
    public void run() {

        FakeCityDAO fakeCities = new FakeCityDAO();

        try {
            for (int i = 0; i < 200; i++) {

                fakeCities.create(faker.address().cityName());
            }
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
