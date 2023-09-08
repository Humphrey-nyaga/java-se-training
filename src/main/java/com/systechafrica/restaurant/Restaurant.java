package com.systechafrica.restaurant;

import java.util.*;
import java.util.logging.Logger;

public class Restaurant {
    private static final Logger LOGGER = Logger.getLogger(Restaurant.class.getName());
    private final Scanner scanner = new Scanner(System.in);
    List<Integer> orderedMealsID = new ArrayList<>();

    public void billing(List<Integer>mealsToBillList) {

        List<Meal> mealsList = new ArrayList<>();
        mealsList.add(new Meal(1, "CHAI", 15));
        mealsList.add(new Meal(2, "ANDAZI", 10));
        mealsList.add(new Meal(3, "TOSTI", 12));
        mealsList.add(new Meal(4, "NDENGU AND ACCOMPLISHMENTS", 70));
        mealsList.add(new Meal(5, "BEANS AND ACCOMPLISHMENTS", 70));
        mealsList.add(new Meal(6, "PILAU VEG", 90));

        List<String> orderedMeals = new ArrayList<>();
        double totalPrice = 0;

        for (Integer orderedID : mealsToBillList) {
            for (Meal meal : mealsList) {
                if (meal.getId() == orderedID) {
                    String name = meal.getName();
                    double price = meal.getPrice();
                    orderedMeals.add(name + "\t" + price);
                    totalPrice += price;
                    break;
                }
            }
        }

        System.out.println("Pay Now For: ");
        for (String meal : orderedMeals) {
            System.out.println(meal);
        }
        System.out.println("Total: " + totalPrice);


    }

    public void order() {
        menu();
        System.out.print("Enter Your Meal/Drink Option: ");
        int mealID = scanner.nextInt();
        orderedMealsID.add(mealID);
        scanner.nextLine();
        userMenu();
        }

     public void userMenu(){
         System.out.print("Do you want to enter another meal/drink option(Y/N): ");
         Character orderAnotherMeal = scanner.next().charAt(0);
         if(orderAnotherMeal.equals('Y')){
             order();
         } else{
             System.out.print("Proceed to Payment(Y/N): ");
             Character proceedToPayment = scanner.next().charAt(0);
             if(proceedToPayment.equals('Y')){
                 billing(orderedMealsID);
             }
         }

     }

    private void payments() {

    }

    public void menu() {
        System.out.println("********** WELCOME ***********");
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
        restaurant.order();
//        if (authentication.login()) {
//            restaurant.menu();
//        } else {
//            LOGGER.warning("Failed to Login");
//        }
    }
}
