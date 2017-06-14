package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {

        try
        {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Fount the driver!");
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        final String DB_URL = "jdbc:mariadb://localhost:3306";
        final String DB_USER = "DAC";
        final String DB_PASS = "Password4040";

        try
        {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Got Connection!");

            connection.setCatalog("DAC");

            PreparedStatement ps = connection.prepareStatement("SELECT first_name, last_name FROM Patient ORDER BY last_name");

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                String lastName = rs.getString("last_name");
                String firstName = rs.getString("first_name");


                System.out.print(firstName+'\t'+lastName+'\n');
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }




}
