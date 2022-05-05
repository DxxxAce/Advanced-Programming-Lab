package com.lab9;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try {

            var continents = new ContinentDAO();
            continents.loadContinents();
            Database.getConnection().commit();

            var countries = new CountryDAO();
            countries.loadCountries();
            Database.getConnection().commit();

            var cities = new CityDAO();
            cities.loadCities();
            Database.getConnection().commit();

            int europeId = continents.findByName("Europe").getId();

            Statement stmt = Database.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT name FROM countries WHERE continent = " + europeId + ";";

            ResultSet rs = stmt.executeQuery(query);
            rs.beforeFirst();
            System.out.println("Countries in Europe:");

            while(rs.next()) {

                System.out.println(rs.getString("name"));
            }

            City city1 = cities.findByName("Bucharest");
            City city2 = cities.findByName("Budapest");

            System.out.println("The distance between Bucharest and Budapest is " +
                    Distance.getDistance(city1.getLatitude(), city1.getLongitude(),
                            city2.getLatitude(), city2.getLongitude()) + " kilometres.");

            MainFrame frame = new MainFrame();
            frame.setVisible(true);

            Database.closeConnection();
        }
        catch (SQLException e1) {

            e1.printStackTrace();

            try {

                Database.getConnection().rollback();
                Database.closeConnection();
            }
            catch (SQLException e2) {

                e2.printStackTrace();
            }
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }
}
