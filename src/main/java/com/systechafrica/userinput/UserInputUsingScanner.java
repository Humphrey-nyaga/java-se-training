package com.systechafrica.userinput;

import com.systechafrica.util.ValidateInput;

import java.util.Scanner;
import java.util.logging.Logger;

public class UserInputUsingScanner {
    private static final Logger LOGGER = Logger.getLogger(UserInputUsingScanner.class.getName());

    public static void main(String[] args) {
        final String DB_USERNAME = "user254";
        final String DB_PASSWORD = "Admin123";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if(ValidateInput.validate(password) && ValidateInput.validate(username)) {
            if (username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)) {
                System.out.println("Welcome to our website!!");
            } else {
                System.out.println("Incorrect username or password!!");
            }
        }else{
            throw new IllegalStateException("Invalid Input Length");
        }
    }

}
