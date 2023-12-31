package com.systechafrica.atmmachine;

import com.systechafrica.part1.constant.Constants;

import java.util.Scanner;
import java.util.logging.Logger;

public class ATMMachine {
    private static final Logger LOGGER = Logger.getLogger(ATMMachine.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    double openingBalance = 1000;
    // final double TRANSACTION_PERCENTAGE = ;

    public boolean isValidLogin() {
        final String DB_USERNAME = "user254";
        final String DB_PASSWORD = "Admin123";

        int count = 0;
        try (Scanner scanner = new Scanner(System.in);) {

            while (count < 3) {

                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();

                if (username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)) {
                    return true;
                } else
                    System.out.println("Incorrect username or password!!");
                count++;
            }
            LOGGER.warning("Login Attempts Limit Exceeded!");
        } catch (Exception e) {
            LOGGER.info("Exception Encountered" + e.getMessage());
        }
        return false;

    }

    public double checkBalance() {
        System.out.println("Balance is: " + openingBalance);
        return openingBalance;
    }

    public double deposit() {
        System.out.print("Enter Amount to Deposit: ");
        double depositAmount = scanner.nextInt();
        if (depositAmount < 1) {
            System.out.println("\nAmount Cannot be less than One");
        } else {
            openingBalance += depositAmount;
            LOGGER.info("\nYour deposit of: " + depositAmount + " was successful");
            LOGGER.info("\nYour New Balance is: !" + openingBalance);
        }
        return openingBalance;

    }

    public void withdraw() {
        System.out.print("Enter Amount to Withdraw: ");
        int withdrawAmount = scanner.nextInt();
        double transactionCharge = withdrawAmount * Constants.RATE;
        if (withdrawAmount + transactionCharge > openingBalance) {
            System.out.print("\nInsufficient Balance!");
        } else {
            openingBalance -= withdrawAmount;
            openingBalance -= transactionCharge;
            LOGGER.info("\nAmount withdrawn successfully is: !" + withdrawAmount);
            LOGGER.info("Transaction charge is: !" + transactionCharge);
            LOGGER.info("Account balance is: !" + openingBalance + "\n");
        }
    }

    public void transfer() {
        System.out.print("Enter Amount to Transfer: ");
        double transferAmount = scanner.nextInt();
        if (transferAmount > openingBalance) {
            System.out.print("\nInsufficient Balance!");
        } else {
            openingBalance -= transferAmount;
            LOGGER.info("\n Amount transferred successfully is: !" + transferAmount);
            LOGGER.info("Account balance is: !" + openingBalance + "\n");
        }
    }

    public void initiateTransaction() {
        boolean isActive = true;
        while (isActive) {
            System.out.println("***************");
            System.out.println("ATM SIMULATOR");
            System.out.println("\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"");
            System.out.println("ATM SERVICES");
            System.out.println("__________________");
            System.out.println("\n" +
                    "1. Check Balance\n" +
                    "2. Deposit\n" +
                    "3. Withdraw\n" +
                    "4. Transfer Cash\n" +
                    "5. Quit");
            System.out.println("\n");
            System.out.print("Choose the service: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    checkBalance();
                    break;
                case "2":
                    deposit();
                    break;
                case "3":
                    withdraw();
                    break;
                case "4":
                    transfer();
                    break;
                case "5":
                    isActive = false;
                    break;
            }

        }
    }

    public static void main(String[] args) {
        ATMMachine app = new ATMMachine();
        if (app.isValidLogin()) {
            app.initiateTransaction();
        }

        // LOGGER.info("hello "+ isValidUser);

    }

}
