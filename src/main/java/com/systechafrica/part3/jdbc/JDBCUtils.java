package com.systechafrica.part3.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public static void createTable()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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


        } catch (ClassNotFoundException e) {
            LOGGER.info("Driver loading error " + e.getMessage() + "\n");

        } catch (SQLException e) {
            LOGGER.info("Database Error " + e.getMessage() + "\n");

        }
    }

    public static void main(String[] args) {
        createTable();
    }
}
