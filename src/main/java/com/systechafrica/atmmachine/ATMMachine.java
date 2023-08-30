package com.systechafrica.atmmachine;

import com.systechafrica.arrays.WorkingWithArrays;

import java.util.Scanner;
import java.util.logging.Logger;

public class ATMMachine {
    private static final Logger LOGGER = Logger.getLogger(WorkingWithArrays.class.getName());
    double openingBalance = 1000;
    final double TRANSACTION_PERCENTAGE = 0.02;

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
        boolean isActive = true;
        while(isActive) {
            System.out.println("***************\n");
            System.out.println("ATM SIMULATOR\n");
            System.out.println("\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\n");
            System.out.println("ATM SERVICES\n");
            System.out.println("__________________\n");
            System.out.println("\n" +
                    "1. Check Balance\n" +
                    "2. Deposit\n" +
                    "3. Withdraw\n" +
                    "4. Transfer Cash\n" +
                    "5. Quit");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose the service: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Balance is: " + openingBalance);
                    break;
                case "2":
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = scanner.nextInt();
                    openingBalance += depositAmount;
                    break;
                case "3":
                    System.out.print("Enter Amount to Withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    double transactionCharge = withdrawAmount * TRANSACTION_PERCENTAGE;
                    if (withdrawAmount + transactionCharge > openingBalance) {
                        System.out.print("Withdrawal Amount is Higher than the balance!");
                        break;
                    } else {
                        openingBalance -= withdrawAmount;
                        openingBalance -= transactionCharge;
                        LOGGER.info("Amount withdrawn successfully is: !" + withdrawAmount);
                        LOGGER.info("Transaction charge is: !" + transactionCharge);
                        LOGGER.info("Account balance is: !" + openingBalance);
                    }
                    break;
                case "4":
                    System.out.print("Enter Amount to Transfer: ");
                    double transferAmount = scanner.nextInt();
                    if (transferAmount > openingBalance) {
                        System.out.print("Insufficient Balance!");
                        break;
                    } else {
                        openingBalance -= transferAmount;
                        LOGGER.info("Amount transferred successfully is: !" + transferAmount);
                        LOGGER.info("Account balance is: !" + openingBalance);
                    }
                    break;
                case "5":
                    isActive = false;
                    break;
            }

        }
    }
    public static void main(String[] args) {
        ATMMachine app = new ATMMachine();
        if(app.isValidLogin()) {
            app.userAccountTransaction();
        }

        //LOGGER.info("hello "+ isValidUser);


    }


}
