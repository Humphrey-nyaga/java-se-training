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
    public boolean login(){
        //? try three times only, exit if not logged in
        int loginTries = 1;
        boolean loggedIn = false;
        while(loginTries <= 3){
            System.out.print("Enter your password: ");
            String userPassword = scanner.nextLine();
            if(userPassword.equals(DEFAULT_PASSWORD)){
               // show menu
                loggedIn = true;
                break;
            }
            System.out.println("Wrong password.");
            loginTries++;
        }
        return loggedIn;

    }
    public void displayMenu(){}
    public void checkBalance(){
        System.out.println("Your balance is: "+ runningBalance);
    }
    public void performDeposit(){
        //? get amount to deposit
        double amountToDeposit = scanner.nextDouble();
        //? add amount to running balance
        runningBalance += amountToDeposit;
    }
    public void performWithdrawal(){
        //? get amount to withdraw
        //? calculate withdraw + charges
        //? check if running balance is sufficient
    }
    public void performTransfer(){
        //? get transfer amount
        //? subtract amount from running balance
    }
    public void printReceipt(){}


    public static void main(String[] args) {
        ATMMachine2 app = new ATMMachine2();
        boolean loggedIn = app.login();
        if(loggedIn){
            System.out.println("Logged in successfully");
            //show menu
        }else{
            System.out.println("Maximum attempts failed");
        }
    }
}
