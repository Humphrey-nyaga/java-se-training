package com.systechafrica.restaurant;

import java.util.*;
import java.util.logging.Logger;

public class Restaurant {
    private static final Logger LOGGER = Logger.getLogger(Restaurant.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    List<Integer> orderedMealsIDsList = new ArrayList<>();

    public double billing(List<Integer> mealsToBillList) {

        List<Meal> mealsList = new ArrayList<>();
        mealsList.add(new Meal(1, "CHAI", 15));
        mealsList.add(new Meal(2, "ANDAZI", 10));
        mealsList.add(new Meal(3, "TOSTI", 12));
        mealsList.add(new Meal(4, "NDENGU AND ACCOMPLISHMENTS", 70));
        mealsList.add(new Meal(5, "BEANS AND ACCOMPLISHMENTS", 70));
        mealsList.add(new Meal(6, "PILAU VEG", 90));

        List<String> orderedMeals = new ArrayList<>();
        double totalBill = 0;

        for (Integer orderedID : mealsToBillList) {
            for (Meal meal : mealsList) {
                if (meal.getId() == orderedID) {
                    String name = meal.getName();
                    double price = meal.getPrice();
                    orderedMeals.add(name + "\t" + price);
                    totalBill += price;
                    break;
                }
            }
        }

        System.out.println("Pay Now For: ");
        for (String meal : orderedMeals) {
            System.out.println(meal);
        }
        System.out.println("*************************");
        System.out.println("Total: " + totalBill);
        return totalBill;

    }

    public void order() {
        System.out.println();
        System.out.print("Enter Your Meal/Drink Option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 7 -> {
                //If Quit option is chosen, check if orders is placed and bill before exit.
                if (orderedMealsIDsList.isEmpty()) {
                    LOGGER.info("User quit before placing an order");
                    System.exit(0);
                } else {
                    payments(billing(orderedMealsIDsList));
                }
            }
            case 1, 2, 3, 4, 5, 6 -> {
                orderedMealsIDsList.add(option);
                scanner.nextLine();
                prompt();
            }
            default -> {
                System.out.println("invalid Option!! Try Again");
            }
        }
    }

    public void prompt() {
        System.out.print("Do you want to enter another meal/drink option(Y/N): ");
        Character orderAnotherMeal = scanner.next().charAt(0);
        if (orderAnotherMeal.equals('Y')) {
            order();
        } else {
            System.out.println("************************");
            System.out.print("Proceed to Payment(Y/N): ");
            Character proceedToPayment = scanner.next().charAt(0);
            if (proceedToPayment.equals('Y')) {
                payments(billing(orderedMealsIDsList));
            }
        }

    }

    private void payments(double amountToPay) {
        Scanner payment = new Scanner(System.in);
        System.out.print("Enter amount to Pay: ");
        double cashGivenToPay = payment.nextDouble();
        if (cashGivenToPay < amountToPay) {
            System.out.println("Amount given cannot be less than the Bill provided!!. Try a higher amount.");
            System.out.println();
            payments(billing(orderedMealsIDsList));
        } else {
            double balance = cashGivenToPay - amountToPay;
            System.out.println("Your balance is: " + balance);
            System.out.println("*****************************");
        }

        payment.close();
        LOGGER.info("Payment for order completed Successfully");
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
        boolean loggedIn = authentication.login();
        if (loggedIn) {
            System.out.println("Logged in successfully");
            while (true) {
                try {
                    restaurant.menu();
                    restaurant.order();
                } catch (Exception e) {
                    scanner.close();
                    System.exit(-1);
                }
            }
        } else {
            LOGGER.warning("Failed to Login");
        }
    }
}
