package com.systechafrica.pos;

import java.util.Scanner;
import java.util.logging.Logger;


public class Authentication {
    private static final Logger LOGGER = Logger.getLogger(Authentication.class.getName());

     final String DB_USERNAME = "admin";
     final String DB_PASSWORD = "Admin123";


    public boolean login() {
        int loginTriesCount = 0;
        while (loginTriesCount < 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)) {
                return true;
            } else
                System.out.println("Incorrect username or password!!");
            loginTriesCount++;
        }
        LOGGER.warning("Login Attempts Limit Exceeded!");
        return false;
    }
}
