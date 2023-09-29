package com.systechafrica.pos.posreviewed;

import com.systechafrica.pos.posreviewed.logger.FileLogger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static com.systechafrica.pos.posreviewed.DatabaseUtils.connect;

public class Authentication {
     private static Logger LOGGER = FileLogger.getLogger();

    // final String DB_USERNAME = "admin";
    // final static String DB_PASSWORD = "Admin123";

    public boolean login() {
        int loginTries = 0;
        Scanner scanner = new Scanner(System.in);

        while (loginTries < 3) {
            try {
                System.out.println("**********LOGIN****");
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (validateCredentialInDatabase(username, password)) {
                    LOGGER.info("Login attempt from: " + username + " successful \n");
                    return true;
                } else {
                    System.out.println("Incorrect username or password!!");
                }
                loginTries++;
            } catch (InputMismatchException e) {
                LOGGER.info("Input Does Not Match Required Type: " + e.getMessage());
            } catch (Exception e) {
                LOGGER.info("Error While Logging In: " + e.getMessage());
            }
        }

        scanner.close();

        LOGGER.warning("Login Attempts Limit Exceeded by user \n");
        return false;
    }

    private static boolean validateCredentialInDatabase(String username, String password) {
        try {
            String hashedPassword = passwordHasher(password);
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
    public static String passwordHasher(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] message = password.getBytes(StandardCharsets.UTF_8);
            messageDigest.update(message);
            byte[] passWordDigest = messageDigest.digest();
            return bytesToString(passWordDigest);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.severe("Hashing Algorithm Error: " + e.getMessage());
        }
        return "";
    }

    public static String bytesToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
