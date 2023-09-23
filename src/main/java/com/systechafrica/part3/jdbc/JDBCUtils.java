package com.systechafrica.part3.jdbc;

import java.sql.*;
import java.util.logging.Logger;

public class JDBCUtils {
    private static final Logger LOGGER = Logger.getLogger(JDBCUtils.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3306/javase";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "@Myadmin123";

    /*public static void createDatabase(String databaseName)  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String createDbStmt = "CREATE DATABASE IF NOT EXISTS " + databaseName;// unsafe sql not recommended in production
            PreparedStatement preparedStatement = conn.prepareStatement(createDbStmt);
            preparedStatement.executeUpdate();
            LOGGER.info("Database " + databaseName + " created successfully...");
            conn.close();


        } catch (ClassNotFoundException e) {
            LOGGER.info("Driver loading error " + e.getMessage() + "\n");

        } catch (SQLException e) {
            LOGGER.info("Database Error " + e.getMessage() + "\n");

        }
    }*/
    public static Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createTable()  {
        try {
            Connection conn = connect();
            String createTableStmt = """
                    CREATE TABLE customer(
                        id  INT PRIMARY KEY AUTO_INCREMENT,
                        firstname VARCHAR(128),
                        lastname  VARCHAR(128),
                        address VARCHAR(128),
                        contact VARCHAR(128),
                        email VARCHAR(128));
                    \s""";
            PreparedStatement preparedStatement = conn.prepareStatement(createTableStmt);
            preparedStatement.executeUpdate();
            LOGGER.info("Table  customer created successfully...");
            conn.close();
        }catch (SQLException e) {
            LOGGER.info("Database Error " + e.getMessage() + "\n");

        }
    }

    public static int insertDataToDatabase(Customer customer){
        String insertQuery = "INSERT INTO customer(firstname, lastname, address, contact, email) VALUES (?,?,?,?,?);";

        try {
            Connection conn = connect();
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getContact());
            preparedStatement.setString(5, customer.getEmail());
            int rows =  preparedStatement.executeUpdate();
            LOGGER.info("Customer added into the database correctly...");
            conn.close();
            return rows;
        }catch (SQLException e) {
            LOGGER.info("Database Error " + e.getMessage() + "\n");
        }
        LOGGER.info(" Customer Insert Into Database Failed... ");
        return -1;
    }

    public static void main(String[] args) {
        //createTable();
        Customer customer = new Customer("John", "Doe", "123 Elm St", "555-123-4567", "john@example.com");
        insertDataToDatabase(customer);

    }
}
