package com.lab8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try {

            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();

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

            Database.getConnection().close();
        }
        catch (SQLException e1) {

            e1.printStackTrace();

            try {

                Database.getConnection().rollback();
            }
            catch (SQLException e2) {

                e2.printStackTrace();
            }
        }
    }
}
