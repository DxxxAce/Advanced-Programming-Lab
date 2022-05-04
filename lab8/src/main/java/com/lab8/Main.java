package com.lab8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;
        Statement stmt = null;

        try {

            connection = Database.getConnection();

            var continents = new ContinentDAO();
            continents.create("Europe");
            connection.commit();

            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");

            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);

            connection.commit();

            stmt = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            String query = "SELECT name FROM countries WHERE id = " + europeId +";";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Countries in Europe:");
            rs.beforeFirst();

            while(rs.next()) {

                System.out.println(rs.getString("name"));
            }

            Database.closeConnection();
        }
        catch (SQLException e1) {

            e1.printStackTrace();

            try {

                if (connection != null) {

                    connection.rollback();
                }
            }
            catch (SQLException e2) {

                e2.printStackTrace();
            }

            try{
                if(stmt != null) {

                    stmt.close();
                }
            }
            catch(SQLException e3) {

                e3.printStackTrace();
            }

            Database.closeConnection();
        }
    }
}
