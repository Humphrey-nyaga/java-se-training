package com.systechafrica.part3.jdbc;

import java.sql.*;
import java.util.logging.Logger;

public class JDBCUtils {
    private static final Logger LOGGER = Logger.getLogger(JDBCUtils.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3308/javase";
    private static final String USERNAME = "javase";
    private static final String PASSWORD = "javase";

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
    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.info("Error encountered: " + ex.getMessage());
        }
        return null;
    }

    public static void createTable() {
        try {
            Connection conn = connect();
            String createTableStmt = """
                    CREATE TABLE  IF  NOT EXISTS customer(
                        id  INT PRIMARY KEY AUTO_INCREMENT,
                        firstname VARCHAR(128),
                        lastname  VARCHAR(128),
                        address VARCHAR(128),
                        contact VARCHAR(128),
                        email VARCHAR(128));
                    \s""";
            assert conn != null;
            PreparedStatement preparedStatement = conn.prepareStatement(createTableStmt);
            preparedStatement.executeUpdate();
            LOGGER.info("Table  customer created successfully...");
            conn.close();
        } catch (SQLException e) {
            LOGGER.info("A database error was encountered: " + e.getMessage() + "\n");

        }
    }

    public static boolean insertDataToDatabase(Customer customer) {
        String insertQuery = "INSERT INTO customer(firstname, lastname, address, contact, email) VALUES (?,?,?,?,?);";

        try {
            Connection conn = connect();
            assert conn != null;
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getContact());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.executeUpdate();
            LOGGER.info("Customer added into the database correctly...");
            conn.close();
            return true;
        } catch (SQLException e) {
            LOGGER.info("Database Error " + e.getMessage() + "\n");
            LOGGER.info(" Customer Insert Into Database Failed... ");
        }
        return false;
    }

    public static void deleteCustomerByEmail(String email) {
        String deleteQuery = "DELETE FROM customer WHERE email = ?;";
        try {
            Connection conn = connect();
            assert conn != null;
            PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setString(1, email);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                LOGGER.info("Customer with email " + email + " deleted successfully.");
            } else {
                LOGGER.info("No customer found with email " + email + ". No deletion performed.");
            }

        } catch (SQLException e) {
            LOGGER.info("Error Deleting Customer with email" + email);
            LOGGER.info("Error: " + e.getMessage());

        }
    }

    public static void updateCustomerById(Customer updatedCustomer, int id) {
        String updateQuery = "UPDATE customer SET firstname = ?, lastname = ?, address = ?, contact = ?, email = ? WHERE id = ?;";
        try {
            PreparedStatement preparedStatement;
            try (Connection conn = connect()) {
                assert conn != null;
                preparedStatement = conn.prepareStatement(updateQuery);
            }
            preparedStatement.setString(1, updatedCustomer.getFirstName());
            preparedStatement.setString(2, updatedCustomer.getLastName());
            preparedStatement.setString(3, updatedCustomer.getAddress());
            preparedStatement.setString(4, updatedCustomer.getContact());
            preparedStatement.setString(5, updatedCustomer.getEmail());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            LOGGER.info("Customer of id: " + id + " has been updated successfully");
        } catch (SQLException e) {
            LOGGER.info("Error updating Customer with id" + id);
            LOGGER.info("Database Error: " + e.getMessage());

        }
    }

    public static void findAllCustomers() {
        String selectQuery = "SELECT * FROM customer;";
        try {
            Connection conn = connect();
            assert conn != null;
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                String contact = resultSet.getString("contact");
                String email = resultSet.getString("email");
                Customer customer = new Customer(id, firstname, lastname, address, contact, email);
                System.out.println(customer);
            }
        } catch (SQLException ex) {
            LOGGER.info("Error retrieving customers: " + ex.getMessage());
        }
    }

    public static void findCustomerByEmail(String custEmail) {
        String selectQuery = "SELECT * FROM customer WHERE email = ?;";
        try {
            Connection conn = connect();
            assert conn != null;
            PreparedStatement selectCustomerByEmailStatement = conn.prepareStatement(selectQuery);
            selectCustomerByEmailStatement.setString(1, custEmail);
            ResultSet rs = selectCustomerByEmailStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String email = rs.getString("email");
                Customer customer = new Customer(id, firstname, lastname, address, contact, email);
                System.out.println(customer);
            }

        } catch (SQLException ex) {
            LOGGER.info("Error retrieving customer by email: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
      //  createTable();
        Customer customer1 = new Customer("John", "Doe", "123 Elm St", "555-123-4567", "john@example.com");
        insertDataToDatabase(customer1);
        //deleteCustomerByEmail("john@example.com");
        Customer customer2 = new Customer("Alice", "Smith", "456 Oak St", "555-987-6543", "alice@example.com");
        insertDataToDatabase(customer2);
        Customer customer3 = new Customer("Bob", "Johnson", "789 Maple St", "555-567-8901", "bob@example.com");
        insertDataToDatabase(customer3);
        Customer customer4 = new Customer("Eve", "Brown", "321 Birch St", "555-345-6789", "eve@example.com");
        insertDataToDatabase(customer4);
        Customer customer5 = new Customer("Charlie", "Wilson", "654 Pine St", "555-234-5678", "charlie@example.com");
        insertDataToDatabase(customer5);

    }
}
