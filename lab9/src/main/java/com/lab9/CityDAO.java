package com.lab9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {

    public void create(String name, int country, boolean capital, float latitude, float longitude)
            throws SQLException {

        Connection con = Database.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into cities (name, country, capital, latitude, longitude)" +
                        "values (?, ?, ?, ?, ?)")) {

            pstmt.setString(1, name);
            pstmt.setInt(2, country);
            pstmt.setBoolean(3, capital);
            pstmt.setFloat(4, latitude);
            pstmt.setFloat(5, longitude);
            pstmt.executeUpdate();
        }
    }

    public City findByName(String name) throws SQLException {

        name = name.replaceAll("'", " ");

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from cities where name='" + name + "'")) {

            City city = null;

            while (rs.next()) {

                city = new City(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getBoolean(4),
                        rs.getFloat(5), rs.getFloat(6));
            }

            return city;
        }
    }

    public City findById(int id) throws SQLException {

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from cities where id='" + id + "'")) {

            City city = null;

            while (rs.next()) {

                city = new City(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getBoolean(4),
                        rs.getFloat(5), rs.getFloat(6));
            }

            return city;
        }
    }

    public List<City> findAll() throws SQLException {

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from cities")) {

            List<City> cities = new ArrayList<>();

            while (rs.next()) {

                cities.add(new City(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getBoolean(4),
                        rs.getFloat(5), rs.getFloat(6)));
            }

            return cities;
        }
    }

    public void loadCities() {

        String line = "";
        String sep = ",";

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/resources/concap.csv"));

            while ((line = br.readLine()) != null) {

                String[] city = line.split(sep);

                try {

                    var countries = new CountryDAO();
                    create(city[1].replaceAll("'", " "), countries.findByName(city[0]).getId(), true,
                            Float.parseFloat(city[2]), Float.parseFloat(city[3]));
                }
                catch (SQLException e) {

                    e.printStackTrace();
                }
            }
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }
}
