package com.systechafrica.atmmachine;

import java.util.Scanner;
import java.util.logging.Logger;

public class ATMMachine2 {
    private static final Logger LOGGER = Logger.getLogger(ATMMachine2.class.getName());
    Scanner scanner = new Scanner(System.in);
    final double INITIAL_BALANCE = 1000.00;
    double runningBalance = INITIAL_BALANCE;
    public void login(){

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
    public void performWithdrawal(){}
    public void performTransfer(){}
    public void printReceipt(){}


    public static void main(String[] args) {
        ATMMachine2 app = new ATMMachine2();
    }
}
