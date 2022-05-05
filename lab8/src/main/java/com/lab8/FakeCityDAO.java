package com.lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FakeCityDAO {

    public void create(String name)
            throws SQLException {

        Connection con = DataSource.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into fake_cities (name)" + "values (?)")) {

            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public FakeCity findByName(String name) throws SQLException {

        name = name.replaceAll("'", " ");

        Connection con = DataSource.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from fake_cities where name='" + name + "'")) {

            FakeCity city = null;

            while (rs.next()) {

                city = new FakeCity(rs.getInt(1), rs.getString(2));
            }

            return city;
        }
    }

    public FakeCity findById(int id) throws SQLException {

        Connection con = DataSource.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from fake_cities where id='" + id + "'")) {

            FakeCity city = null;

            while (rs.next()) {

                city = new FakeCity(rs.getInt(1), rs.getString(2));
            }

            return city;
        }
    }

    public List<FakeCity> findAll() throws SQLException {

        Connection con = DataSource.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from fake_cities")) {

            List<FakeCity> cities = new ArrayList<>();

            while (rs.next()) {

                cities.add(new FakeCity(rs.getInt(1), rs.getString(2)));
            }

            return cities;
        }
    }
}
