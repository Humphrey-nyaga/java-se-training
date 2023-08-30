package com.systechafrica.atmmachine;

import com.systechafrica.arrays.WorkingWithArrays;

import java.util.Scanner;
import java.util.logging.Logger;

public class ATMMachine {
    private static final Logger LOGGER = Logger.getLogger(WorkingWithArrays.class.getName());
    int openingBalance = 1000;

    public boolean isValidLogin() {
        final String DB_USERNAME = "user254";
        final String DB_PASSWORD = "Admin123";

        int count = 0;
        while (count < 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)) {
                System.out.println("Welcome to our website!!");
                return true;
            } else
                System.out.println("Incorrect username or password!!");
            count++;
        }
        LOGGER.warning("Login Attempts Limit Exceeded!");
        return false;
    }

    public void userAccountTransaction() {
        System.out.println("***************\n");
        System.out.println("ATM SIMULATOR\n");
        System.out.println("\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\n");
        System.out.println("ATM SERVICES\n");
        System.out.println("__________________\n");
        System.out.println("\n"+
                "1. Check Balance\n" +
                "2. Deposit\n" +
                "3. Withdraw\n" +
                "4. Transfer Cash\n" +
                "5. Quit");

    }
    public static void main(String[] args) {
        ATMMachine app = new ATMMachine();
        if(app.isValidLogin()) {
            app.userAccountTransaction();
        }

        //LOGGER.info("hello "+ isValidUser);


    }


}
