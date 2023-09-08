package com.systechafrica.restaurant;

import java.util.Scanner;
import java.util.logging.Logger;

public class Authentication {
    private static final Logger LOGGER = Logger.getLogger(Authentication.class.getName());
    final String DB_PASSWORD = "Admin123";

    public boolean login() {
        int loginTriesCount = 0;
        while (loginTriesCount < 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (password.equals(DB_PASSWORD)) {
                return true;
            } else
                System.out.println("Incorrect username or password!!");
            loginTriesCount++;
        }
        LOGGER.warning("Login Attempts Limit Exceeded!");
        return false;
    }
}
