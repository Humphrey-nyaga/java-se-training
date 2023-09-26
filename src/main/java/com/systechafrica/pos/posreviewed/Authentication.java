package com.systechafrica.pos.posreviewed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

import static com.systechafrica.pos.posreviewed.Utils.connect;
import static com.systechafrica.pos.posreviewed.Utils.passwordEncoder;


public class Authentication {
    private static final Logger LOGGER = Logger.getLogger(Authentication.class.getName());

//    final String DB_USERNAME = "admin";
//    final static String DB_PASSWORD = "Admin123";

    public boolean login() {
        int loginTries = 0;
        while (loginTries < 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (validateCredentialInDatabase(username, password)) {
                LOGGER.info("Login attempt from: " + username + " successful \n");
                return true;

            } else
                System.out.println("Incorrect username or password!!");
            loginTries++;
        }
        LOGGER.warning("Login Attempts Limit Exceeded by user ");
        return false;
    }

    private static boolean validateCredentialInDatabase(String username, String password) {
        try {
            String hashedPassword  = passwordEncoder(password);
            Connection conn = connect();
            String query = "SELECT username, password FROM users WHERE username = ? AND password = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashedPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean validUser = resultSet.next();
            conn.close();
            return validUser;
        } catch (SQLException ex) {
            LOGGER.info("Database Error Logging In: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            LOGGER.info("Class Not Found: " + ex.getMessage());
        }
        return false;
    }
}
