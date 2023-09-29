package com.systechafrica.pos.posreviewed;

import com.systechafrica.pos.posreviewed.exceptions.CartIsEmptyException;
import com.systechafrica.pos.posreviewed.exceptions.UserAlreadyExistsException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


public class Utils {
    private static final Logger LOGGER = Logger.getLogger(POSReviewed.class.getName());
    public static int orderID = -1;

    private static final String URL = "jdbc:mysql://localhost:3306/pointofsale";
    private static final String USERNAME = "javase";
    private static final String PASSWORD = "javase";

    static Connection connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    public static String passwordHasher(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] message = password.getBytes(StandardCharsets.UTF_8);
            messageDigest.update(message);
            byte[] passWordDigest = messageDigest.digest();
            return bytesToString(passWordDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
            //LOGGER.warning("Password Encoding Algorithm Does Not Found: " + e.getMessage());
        }
    }

    public static String bytesToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static int createOrderInDatabase() {
        int orderIDInDb = -1;
        try {
            Connection conn = connect();
            String createOrderQuery = "INSERT INTO orders(time, total) VALUES(now(), ?);";
            PreparedStatement createOrderStatement = conn.prepareStatement(createOrderQuery);
            createOrderStatement.setDouble(1, 0.0);
            createOrderStatement.executeUpdate();

            LOGGER.info("Order Created In the Database Successfully\n");
            LOGGER.info("Retrieving the Order ID...\n");
            String orderCreatedIDQuery = "SELECT LAST_INSERT_ID();";
            PreparedStatement getOrderIDStmt = conn.prepareStatement(orderCreatedIDQuery);
            ResultSet rs = getOrderIDStmt.executeQuery();
            while (rs.next()) {
                orderIDInDb = rs.getInt(1);
            }
            LOGGER.info("Order ID Retrieved Successfully..." + orderIDInDb + "\n");
            conn.close();
            orderID = orderIDInDb;
            return orderIDInDb;
        } catch (SQLException ex) {
            LOGGER.info("An error occurred: " + ex.getMessage() + "\n");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return orderIDInDb;
    }

    public static void insertOrderItemsToDatabase(List<Cart> cart) {
        int orderID = createOrderInDatabase();
        try {
            Iterator<Cart> it = cart.iterator();
            Connection conn = connect();
            String insertOrderItems = "INSERT INTO cart(item_id, order_id, quantity, price) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertOrderItems);
            conn.setAutoCommit(false);
            while (it.hasNext()) {
                Cart c = it.next();
                preparedStatement.setInt(1, c.getItem().getId());
                preparedStatement.setInt(2, orderID);
                preparedStatement.setInt(3, c.getItemQuantity());
                preparedStatement.setDouble(4, c.getItem().getItemPrice());
                preparedStatement.addBatch();
            }
            int[] rowsInserted = preparedStatement.executeBatch();
            conn.commit();
            LOGGER.info("Batch Insert of cart items into database completed... \n");
            conn.close();
        } catch (BatchUpdateException ex) {
            LOGGER.info("Batch Insert Erro: " + ex.getMessage() + "\n");
        } catch (SQLException ex) {
            LOGGER.info("Database Error: " + ex.getMessage() + "\n");
        } catch (ClassNotFoundException e) {
            LOGGER.info("Database Error: " + e.getMessage() + "\n");

        }

    }

    public static boolean orderIDIsNonNegative(int orderID) {
        if (orderID > 0) {
            return true;
        }
        throw new CartIsEmptyException("Please Add items to the Cart First!!");
    }

    public static List<Cart> getCartItems(int orderID) {
        List<Cart> cartItems = new ArrayList<>();
        try {
            orderIDIsNonNegative(orderID);
            Connection conn = connect();
            String query = "SELECT item_id, quantity, price FROM cart WHERE order_id = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, orderID);
            ResultSet resultSet = ps.executeQuery();
            LOGGER.info("Cart Items start retrieving from the database... ");
            while (resultSet.next()) {
                int price = resultSet.getInt("price");
                int item_id = resultSet.getInt("item_id");
                int quantity = resultSet.getInt("quantity");
                Item item = new Item(item_id, price);
                Cart cart = new Cart(item, quantity);
                cartItems.add(cart);
            }
            LOGGER.info("Cart Items retrieval finished from the database... ");
            conn.close();
            LOGGER.info("Cart Items: " + cartItems.toString());
            return cartItems;
        } catch (CartIsEmptyException ex) {
            LOGGER.info("Getting Items On an Empty Order Failed... " + ex.getMessage());
        } catch (SQLException e) {
            LOGGER.info("Database Error Retrieving Cart Items: " + e.getMessage() + "\n");
        } catch (ClassNotFoundException ex) {
            LOGGER.info("Database Driver Error: " + ex.getMessage() + "\n");
        }

        return cartItems;
    }

    public static void createDatabaseTables() {
        try {
            Connection conn = connect();
            String createUserTable = """
                        CREATE TABLE IF NOT EXISTS users(
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            username VARCHAR(25) UNIQUE NOT NULL,
                            password VARCHAR(255) NOT NULL);
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
            conn.close();
            createBillingTrigger();
        } catch (SQLException e) {
            LOGGER.info("Database Error Creating Tables: " + e.getMessage() + "\n");
        } catch (ClassNotFoundException ex) {
            LOGGER.info("Database Driver Error: " + ex.getMessage() + "\n");
            ex.printStackTrace();

        }
    }

    public static void createUserInDatabase() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("*******CREATE USER IN DATABASE*********");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            User user = new User(username, password);
            if (userExistsInDatabase(username)) {
                throw new UserAlreadyExistsException("User with username " + username + " already exists!!\n");
            } else {
                Connection conn = connect();
                String createUserQuery = "INSERT INTO users(username, password) VALUES(?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(createUserQuery);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.execute();
                System.out.println();
                LOGGER.info("User Created Successfully in Database\n");
                conn.close();
            }
        }catch (UserAlreadyExistsException ex) {
            LOGGER.info("Exception Creating User: " + ex.getMessage() + "\n");
        } catch (SQLException | ClassNotFoundException ex) {
            LOGGER.info("Exception Creating User: " + ex.getMessage() + "\n");
        }


    }

    public static void createBillingTrigger() {
        String triggerCalculateOrderTotal = "calculate_order_total";

        String triggerQuery = "CREATE TRIGGER " + triggerCalculateOrderTotal + " " +
                "AFTER INSERT ON cart " +
                "FOR EACH ROW " +
                "BEGIN " +
                "    DECLARE order_total DECIMAL(10, 2); " +
                "    SELECT SUM(price * quantity) " +
                "    INTO order_total " +
                "    FROM cart " +
                "    WHERE order_id = NEW.order_id; " +
                "    UPDATE orders " +
                "    SET total = order_total " +
                "    WHERE id = NEW.order_id; " +
                "END;";
        try {
            Connection conn = connect();


            if (!triggerExists(conn, triggerCalculateOrderTotal)) {
                Statement statement = conn.createStatement();
                statement.execute(triggerQuery);
                LOGGER.info("Trigger created successfully.");
            } else {
                LOGGER.info("Trigger exists, skipping creation.");
            }
            conn.close();
        } catch (SQLException e) {
            LOGGER.info("SQL Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.info("Database Connection Error: " + e.getMessage());

        }
    }

    private static boolean triggerExists(Connection connection, String triggerToSearch) throws SQLException {
        String query = "SELECT trigger_name FROM information_schema.triggers WHERE trigger_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, triggerToSearch);
        return preparedStatement.executeQuery().next();
    }

    public static boolean userExistsInDatabase(String username) {
        try {
            Connection conn = connect();
            String query = "SELECT username FROM users WHERE username = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            return preparedStatement.executeQuery().next();
        } catch (ClassNotFoundException e) {
            LOGGER.info("Database Driver Error: " + e.getMessage());
        } catch (SQLException e) {
            LOGGER.info("Database Error Finding Existing User: " + e.getMessage());
        }
        return false;
    }

    public static int promptCreateUserOrLogin() {
        System.out.println("Choose an option to Create Account / Login: ");
        System.out.println(
                """
                        1. Create User 
                        2. Login
                        """);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Option: ");
        int option = scanner.nextInt();
       return option;
    }
}


