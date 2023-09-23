package com.systechafrica.atmmachine;

import java.util.Scanner;
import java.util.logging.Logger;

public class ATMMachine2 {
    private static final Logger LOGGER = Logger.getLogger(ATMMachine2.class.getName());
    Scanner scanner = new Scanner(System.in);
    final String DEFAULT_USERNAME = "user254";
    final String DEFAULT_PASSWORD = "Admin123";
    final double INITIAL_BALANCE = 1000.00;
    final double WITHDRAWAL_CHARGES = 0.02;
    double runningBalance = INITIAL_BALANCE;

    public boolean login() {
        //? try three times only, exit if not logged in
        int loginTries = 1;
        boolean loggedIn = false;
        while (loginTries <= 3) {
            System.out.print("Enter your password: ");
            String userPassword = scanner.nextLine();
            if (userPassword.equals(DEFAULT_PASSWORD)) {
                // show menu
                loggedIn = true;
                break;
            }
            LOGGER.info("Wrong password.");
            loginTries++;
        }
        return loggedIn;

    }

    public void displayMenu() {
        System.out.println("**************************************");
        System.out.println("*************ATM SIMULATOR************");
        System.out.println("**************************************");
        System.out.println("************ATM SERVICES**************");
        System.out.println("______________________________________");
        System.out.println(
                """
                        1. Check Balance
                        2. Deposit
                        3. Withdraw
                        4. Transfer Cash
                        5. Quit""");
        System.out.println("\n");
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + runningBalance);
    }

    public void performDeposit() {
        //? get amount to deposit
        System.out.print("Enter Amount to Deposit: ");
        double amountToDeposit = scanner.nextDouble();
        if(amountToDeposit < 1) {
            System.out.println("\n Amount Cannot be less than One");
        }
        else{
            runningBalance += amountToDeposit;
            System.out.println("\nYour deposit of: "+ amountToDeposit +" was successful");
            System.out.println("\nYour New Balance is: " + runningBalance);
        }
    }

    public void performWithdrawal() {
        //? get amount to withdraw
        //? calculate withdraw + charges
        //? check if running balance is sufficient
        System.out.print("Enter Amount to Withdraw: ");
        double withdrawAmount = scanner.nextInt();
        double transactionCost = withdrawAmount * WITHDRAWAL_CHARGES;
        double withdrawAmountAndTransactionCost = withdrawAmount + transactionCost;
        if (withdrawAmountAndTransactionCost > runningBalance) {
            System.out.print("\nInsufficient Balance!...Try a smaller amount");
        } else {
            runningBalance -= withdrawAmount;
            runningBalance -= transactionCost;
            System.out.println("\nAmount withdrawn successfully is: " + withdrawAmount);
            System.out.println("Transaction charge is: " + transactionCost);
            System.out.println("Account balance is: " + runningBalance + " ");
        }
    }

    public void performTransfer() {
        //? get transfer amount
        //? subtract amount from running balance
    }

    public void printReceipt() {
    }


    public static void main(String[] args) {
        ATMMachine2 app = new ATMMachine2();
        boolean loggedIn = app.login();
        if (loggedIn) {
            System.out.println("Logged in successfully");
            boolean keepShowingMenu = true;
            while (keepShowingMenu) {
                app.displayMenu();
              try {
                  System.out.print("Choose your option: ");
                  int option = app.scanner.nextInt();
                  switch (option) {
                      case 1 -> app.checkBalance();
                      case 2 -> app.performDeposit();
                      case 3 -> app.performWithdrawal();
                      case 4 -> app.performTransfer();
                      case 5 -> keepShowingMenu = false;
                      default -> System.out.println("Invalid option...Try Again!");
                  }
              }catch (Exception e){
                app.scanner.nextLine();
                System.out.println("Only Integers are allowed!!");
              }
            }
        }


//                if(option == 1){
//                    app.checkBalance();
//                } else if (option == 2) {
//                    app.performDeposit();
//                } else if (option == 3) {
//                    app.performWithdrawal();
//
//                } else if (option == 4) {
//                    app.performTransfer();
//                } else if (option == 5) {
//                    keepShowingMenu =  false;
//                } else {
//                    System.out.println("Invalid option...Try Again");
//                }
//            }
//        }else{
//            System.out.println("Maximum attempts failed");
//        }

    }
}
