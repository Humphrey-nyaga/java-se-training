package com.systechafrica.pos;

import java.util.Scanner;
import java.util.logging.Logger;


public class Authentication {
    private static final Logger LOGGER = Logger.getLogger(Authentication.class.getName());

     final String DB_USERNAME = "admin";
     final String DB_PASSWORD = "Admin123";


    public boolean login() {
        int loginTries = 0;
        while (loginTries < 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)) {
                LOGGER.info("Login attempt from: " + DB_USERNAME + "successful \n");
                scanner.close();
                return true;

            } else
                System.out.println("Incorrect username or password!!");
            loginTries++;
            scanner.close();
        }
        LOGGER.warning("Login Attempts Limit Exceeded by user: " + DB_USERNAME + "\n");
        return false;
    }
}
