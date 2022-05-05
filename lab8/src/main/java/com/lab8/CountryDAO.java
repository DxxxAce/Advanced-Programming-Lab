package com.lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    public void create(String name, int continent, String code) throws SQLException {

        Connection con = Database.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (name, continent, code) values (?, ?, ?)")) {

            pstmt.setString(1, name);
            pstmt.setInt(2, continent);
            pstmt.setString(3, code);
            pstmt.executeUpdate();
        }
    }

    public Country findByName(String name) throws SQLException {

        name = name.replaceAll("'", " ");

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from countries where name='" + name + "'")) {

            Country country = null;

            while (rs.next()) {
                country = new Country(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4));
            }

            return country;
        }
    }

    public Country findById(int id) throws SQLException {

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from countries where id='" + id + "'")) {

            Country country = null;

            while (rs.next()) {

                country = new Country(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4));
            }

            return country;
        }
    }

    public List<Country> findAll() throws SQLException {

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from countries")) {

            List<Country> countries = new ArrayList<>();

            while (rs.next()) {

                countries.add(new Country(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4)));
            }

            return countries;
        }
    }

    public void loadCountries() {

        String line = "";
        String sep = ",";

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/resources/concap.csv"));

            while ((line = br.readLine()) != null) {

                String[] country = line.split(sep);

                try {

                    var continents = new ContinentDAO();
                    create(country[0].replaceAll("'", " "),
                            continents.findByName(country[5]).getId(), country[4]);
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
