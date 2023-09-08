package com.systechafrica.restaurant;

import java.util.logging.Logger;

public class Restaurant {
    private static final Logger LOGGER = Logger.getLogger(Restaurant.class.getName());

    public void menu(){
        System.out.println( "********** WELCOME ***********");
        System.out.println("****** SYSTECH RESTAURANT ****");
        System.out.println();
        System.out.printf("%-30s%n", "DRINKS");
        System.out.printf("%-30s%-10s%n", "1. CHAI", "15");
        System.out.printf("%-30s%-10s%n", "2. ANDAZI", "15");
        System.out.printf("%-30s%-10s%n", "3. TOAST", "10");
        System.out.println();
        System.out.printf("%-30s%n", "MEALS");
        System.out.printf("%-30s%-10s%n", "4. NDENGU AND ACCOMPLISHMENTS", "70");
        System.out.printf("%-30s%-10s%n", "5. BEANS AND ACCOMPLISHMENTS", "70");
        System.out.printf("%-30s%-10s%n", "6. PILAU VEG", "90");
        System.out.printf("%-30s%n", "7. QUIT");

    }

    public static void main(String[] args) {
        Authentication authentication = new Authentication();
        Restaurant restaurant = new Restaurant();
        if(authentication.login()){
            restaurant.menu();
        }else {
            LOGGER.warning("Failed to Login");
        }
    }
}
