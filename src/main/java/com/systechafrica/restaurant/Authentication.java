package com.systechafrica.restaurant;


import java.util.Scanner;
import java.util.logging.Logger;

public class Authentication {
    private static final Logger LOGGER = Logger.getLogger(Authentication.class.getName());

    final String DB_USERNAME = "admin";
    final String DB_PASSWORD = "Admin123";


    public boolean login() {
        return isValidLogin(DB_USERNAME, DB_PASSWORD);
    }

    public static boolean isValidLogin(String dbUsername, String dbPassword) {
        var loginTriesCount = 0;
        while (loginTriesCount < 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (username.equals(dbUsername) && password.equals(dbPassword)) {
                scanner.close();
                return true;
            } else
                System.out.println("Incorrect username or password!!");
            loginTriesCount++;
        }
        LOGGER.warning("Login Attempts Limit Exceeded!");
        LOGGER.warning("User exceeded failed login limits!");

        return false;
    }
}
