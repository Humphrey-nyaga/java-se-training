package com.systechafrica.pos.posreviewed;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class Utils {
    private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3306/pointofsale";
    private static final String USERNAME = "javase";
    private static final String PASSWORD = "javase";

    static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // should return an order ID
    public static int createOrderInDatabase() {
        int orderID = -1;
        try {
            Connection conn = connect();
            String createOrderQuery = "INSERT INTO orders(time, total) VALUES(now(), ?);";
            PreparedStatement createOrderStatement = conn.prepareStatement(createOrderQuery);
            createOrderStatement.setDouble(1, 0.0);
            createOrderStatement.executeUpdate();

            LOGGER.info("Order Created In the Database Successfully");
            LOGGER.info("Retrieving the Order ID...");
            String orderCreatedIDQuery = "SELECT LAST_INSERT_ID();";
            PreparedStatement getOrderIDStmt = conn.prepareStatement(orderCreatedIDQuery);
            ResultSet rs = getOrderIDStmt.executeQuery();
            while (rs.next()) {
                orderID = rs.getInt(1);
            }
            LOGGER.info("Order ID Retrieved Successfully..." + orderID);
            conn.close();
            return orderID;
        } catch (SQLException ex) {
            LOGGER.info("An error occurred: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return orderID;
    }

    public static void insertOrderItemsToDatabase(List<Cart> cart){
        int orderID = createOrderInDatabase();
        try {
            Iterator<Cart> it = cart.iterator();
            Connection conn = connect();
            String insertOrderItems = "INSERT INTO cart(item_id, order_id, quantity, price) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertOrderItems);
            conn.setAutoCommit(false);
            while(it.hasNext()){
                Cart c = it.next();
                preparedStatement.setInt(1,c.getItem().getId());
                preparedStatement.setInt(2,orderID);
                preparedStatement.setInt(3,c.getItemQuantity());
                preparedStatement.setDouble(4,c.getItem().getItemPrice());
                preparedStatement.addBatch();
            }
            int[] rowsInserted = preparedStatement.executeBatch();
            LOGGER.info("Records Inserted into Database: " + Arrays.toString(rowsInserted));
            conn.commit();
            LOGGER.info("Items Insert Transaction Committed...: " + Arrays.toString(rowsInserted));
            conn.close();
        } catch (SQLException ex) {
           // LOGGER.info("Database Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createDatabaseTables() {
        try {
            Connection conn = connect();
            String createUserTable = """
                    CREATE TABLE IF NOT EXISTS users(
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        username VARCHAR(25),
                        password VARCHAR(255));
                """;
            PreparedStatement preparedStatement = conn.prepareStatement(createUserTable);
            preparedStatement.executeUpdate();

            String createOrdersTable = """
                    CREATE TABLE IF NOT EXISTS orders (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         time DATETIME NOT NULL,
                         total DECIMAL(10,2) DEFAULT 0.0);
                      """;
            PreparedStatement preparedStatement1 = conn.prepareStatement(createOrdersTable);
            preparedStatement1.executeUpdate();

            String createCartTable = """
                    CREATE TABLE IF NOT EXISTS cart(
                        item_id INT NOT NULL,
                        order_id INT NOT NULL,
                        quantity INT NOT NULL,
                        price DECIMAL(10,2) NOT NULL,
                        PRIMARY KEY (item_id,order_id),
                        FOREIGN KEY (order_id) REFERENCES orders(id));
                    """;
            PreparedStatement preparedStatement2 = conn.prepareStatement(createCartTable);
            preparedStatement2.executeUpdate();

            LOGGER.info("Database tables created successfully...");
            conn.close();
        } catch (SQLException e) {
            LOGGER.info("Database Error Creating Tables: " + e.getMessage() + "\n");
        }
        catch (ClassNotFoundException ex) {
            LOGGER.info("Database Driver Error: " + ex.getMessage() + "\n");

        }
    }

 public static String passwordEncoder(String password) {
     try {
         MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
         byte[] message = password.getBytes(StandardCharsets.UTF_8);
         messageDigest.update(message);
         byte[] passWordDigest = messageDigest.digest();
         return bytesToString(passWordDigest);
     } catch (NoSuchAlgorithmException e) {
         throw new RuntimeException(e);
     }
 }

     public static String bytesToString(byte[] bytes){
         StringBuilder sb = new StringBuilder();
         for (byte b : bytes) {
             sb.append(String.format("%02x", b));
         }
         return sb.toString();
     }

}
