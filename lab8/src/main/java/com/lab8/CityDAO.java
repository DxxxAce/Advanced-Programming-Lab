package com.lab8;

import java.sql.*;

public class CityDAO {

    public void create(String name, int countryId) throws SQLException {

        Connection con = Database.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into cities (name, country) values (?)")) {

            pstmt.setString(1, name);
            pstmt.setInt(2, countryId);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from cities where name='" + name + "'")) {

            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from cities where id='" + id + "'")) {

            return rs.next() ? rs.getString(1) : null;
        }
    }
}
