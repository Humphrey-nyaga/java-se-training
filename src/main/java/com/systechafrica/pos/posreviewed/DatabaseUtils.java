package com.systechafrica.pos.posreviewed;

import com.systechafrica.pos.posreviewed.exceptions.CartIsEmptyException;
import com.systechafrica.pos.posreviewed.exceptions.UserAlreadyExistsException;
import com.systechafrica.pos.posreviewed.exceptions.UsernameOrPasswordCannotBeNull;
import com.systechafrica.pos.posreviewed.logger.FileLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import static com.systechafrica.pos.posreviewed.Constants.*;

public class DatabaseUtils {
    static final Logger LOGGER = FileLogger.getLogger();
    public static int orderID = -1;


    static Connection connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
    }

    public static void createUserInDatabase() {

        try (Connection conn = connect()) {
            LOGGER.info("Creating default user admin in database.");
            String username = POS_USERNAME;
            String password = POS_USER_PASSWORD;

            if (username.isEmpty() || username == null || password.isEmpty() || password == null) {
                LOGGER.info("Empty username or password supplied...");
                throw new UsernameOrPasswordCannotBeNull("Username or password cannot be null or empty!");
            } else {
                User user = new User(username, password);

                if (userExistsInDatabase(username)) {
                    throw new UserAlreadyExistsException("User with username " + username + " already exists!");
                } else {
                    String createUserQuery = "INSERT INTO users(username, password) VALUES(?,?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(createUserQuery);
                    preparedStatement.setString(1, user.getUsername());
                    preparedStatement.setString(2, user.getPassword());
                    preparedStatement.execute();
                    LOGGER.info(username + " User Created Successfully in Database.");
                }
            }
        } catch (UsernameOrPasswordCannotBeNull ex) {
            LOGGER.info("User name or password is null or empty: " + ex.getMessage());
        } catch (UserAlreadyExistsException ex) {
            LOGGER.info("Exception Creating User: " + ex.getMessage());
        } catch (SQLException | ClassNotFoundException ex) {
            LOGGER.info("Database Exception: " + ex.getMessage());
        }
    }

    public static void createDatabaseTables() {
        try (Connection conn = connect()) {
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
                            id    INT PRIMARY KEY AUTO_INCREMENT,
                            time  DATETIME NOT NULL,
                            total DECIMAL(10, 2) DEFAULT 0.0,
                            completed  BOOLEAN DEFAULT FALSE);
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
            createBillingTrigger();
        } catch (SQLException e) {
            LOGGER.info("Database Error Creating Tables: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            LOGGER.info("Database Driver Error: " + ex.getMessage());
            ex.printStackTrace();

        }
    }


    public static int createOrderInDatabase() {
        int orderIDInDb = -1;
        try (Connection conn = connect()) {
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
                orderIDInDb = rs.getInt(1);
            }
            LOGGER.info("Order ID Retrieval Completed." + orderIDInDb);
            orderID = orderIDInDb;
            return orderIDInDb;
        } catch (SQLException ex) {
            LOGGER.info("SQL Error Creating Order: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.info("Database Driver Error: " + e.getMessage());

        }

        return orderIDInDb;
    }

    public static void insertOrderItemsToDatabase(List<Cart> cart) {
        int orderID = createOrderInDatabase();
        try (Connection conn = connect()) {
            Iterator<Cart> it = cart.iterator();
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
            LOGGER.info("Batch Insert of cart items into database completed.");
        } catch (BatchUpdateException ex) {
            LOGGER.info("Batch Insert Error: " + ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.info("Database Error: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.info("Database Error: " + e.getMessage());

        }

    }

    public static boolean orderIDIsNonNegative(int orderID) {
        if (orderID > 0) {
            return true;
        }
        throw new CartIsEmptyException("Please Add items to the Cart First!!");
    }

    public static List<Cart> getCartItemsFromDb(int orderID) {
        List<Cart> cartItems = new ArrayList<>();
        try (Connection conn = connect()) {
            orderIDIsNonNegative(orderID);
            String query = "SELECT item_id, quantity, price FROM cart WHERE order_id = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, orderID);
            ResultSet resultSet = ps.executeQuery();
            LOGGER.info("Cart Items start retrieving from the database.");
            while (resultSet.next()) {
                int price = resultSet.getInt("price");
                int item_id = resultSet.getInt("item_id");
                int quantity = resultSet.getInt("quantity");
                Item item = new Item(item_id, price);
                Cart cart = new Cart(item, quantity);
                cartItems.add(cart);
            }
            LOGGER.info("Cart Items retrieval finished from the database.");
            LOGGER.info("Cart Items: " + cartItems.toString());
            return cartItems;
        } catch (CartIsEmptyException ex) {
            LOGGER.info("Getting Items On an Empty Order Failed... " + ex.getMessage());
        } catch (SQLException e) {
            LOGGER.info("Database Error Retrieving Cart Items: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            LOGGER.info("Database Driver Error: " + ex.getMessage());
        }

        return cartItems;
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
        try (Connection conn = connect()) {
            if (!triggerExists(conn, triggerCalculateOrderTotal)) {
                Statement statement = conn.createStatement();
                statement.execute(triggerQuery);
                LOGGER.info("Trigger created successfully.");
            } else {
                LOGGER.info("Trigger exists, skipping creation.");
            }
        } catch (SQLException e) {
            LOGGER.info("SQL Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.info("Database Connection Error: " + e.getMessage());

        }
    }

    public static double getOrderTotalFromDb(int orderID) {
        try (Connection connection = connect()) {
            String query = "SELECT total FROM orders WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, orderID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                double total = resultSet.getDouble("total");
                return total;
            }
        } catch (SQLException e) {
            LOGGER.info("SQL Exception retrieving order total: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.info("Database Driver Error Exception: " + e.getMessage());
        }
        // todo: handle this value
        return 0.0;
    }

    public static void updateOrderStatusToCompleted(int orderID) {
        try (Connection conn = connect()) {
            String query = "UPDATE orders SET completed = TRUE WHERE id = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, orderID);
            int updatedRows = preparedStatement.executeUpdate();
            LOGGER.info("Order " + orderID + "status updated");
        } catch (SQLException e) {
            LOGGER.info("SQL Error updating order status" + e.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.info("Database driver error: " + e.getMessage());
        }
    }

    private static boolean triggerExists(Connection connection, String triggerToSearch) throws SQLException {
        String query = "SELECT trigger_name FROM information_schema.triggers WHERE trigger_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, triggerToSearch);
        return preparedStatement.executeQuery().next();
    }

    public static boolean userExistsInDatabase(String username) {
        try (Connection conn = connect()) {
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
}
