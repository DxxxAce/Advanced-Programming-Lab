package com.lab8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinentDAO {

    public void create(String name) throws SQLException {

        Connection con = Database.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents (name) values (?)")) {

            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Continent findByName(String name) throws SQLException {

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from continents where name='" + name + "'")) {

            Continent continent = null;

            while (rs.next()) {

                continent = new Continent(rs.getInt(1), rs.getString(2));
            }

            return continent;
        }
    }

    public Continent findById(int id) throws SQLException {

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from continents where id='" + id + "'")) {

            Continent continent = null;

            while (rs.next()) {

                continent = new Continent(rs.getInt(1), rs.getString(2));
            }

            return continent;
        }
    }

    public List<Continent> findAll() throws SQLException {

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from continents")) {

            List<Continent> continents = new ArrayList<>();

            while (rs.next()) {

                continents.add(new Continent(rs.getInt(1), rs.getString(2)));
            }

            return continents;
        }
    }

    public void loadContinents() {

        List<String> continents = new ArrayList<>();

        continents.add("Africa");
        continents.add("Antarctica");
        continents.add("Asia");
        continents.add("Australia");
        continents.add("Europe");
        continents.add("Central America");
        continents.add("North America");
        continents.add("South America");

        try {

            for (String continent : continents) {

                create(continent);
            }
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
