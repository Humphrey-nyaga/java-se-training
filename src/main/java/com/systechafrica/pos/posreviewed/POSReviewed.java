package com.systechafrica.pos.posreviewed;


import com.systechafrica.pos.posreviewed.logger.FileLogger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static com.systechafrica.pos.posreviewed.DatabaseUtils.*;

public class POSReviewed {
    static final Logger LOGGER = FileLogger.getLogger();

    private final List<Cart> customerItems = new ArrayList<>();
    private static List<Cart> CartItemsFromDb = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private  double billAmount = 0;
   // private  double totalBillAmount = 0;

    private double amountGivenByCustomer = 0;
    private double balance = 0;

    public void menu() {
        System.out.println("*********************");
        System.out.println("SYSTECH POS SYSTEM");
        System.out.println("*********************");
        System.out.println(
                """
                        1. ADD ITEM
                        2. MAKE PAYMENT
                        3. PRINT RECEIPT
                        4. QUIT
                        """);

        try {
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> addItem();
                case 2 -> payment();
                case 3 -> printReceipt();
                case 4 -> System.exit(-1);
                default -> System.out.println("Invalid Option");
            }
            scanner.nextLine();
        } catch (InputMismatchException ex) {
            LOGGER.info("Only Integers Are Allowed: " + ex.getMessage());
            scanner.nextLine();
        }
    }

    private void addItem() {
        System.out.println("Add items to the cart:");
        char addMoreItemsOption;

        do {
            System.out.print("Enter Item Code: ");
            int itemCode;
            itemCode = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Item price: ");
            double itemPrice = scanner.nextDouble();
            System.out.print("Enter Item quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            Item item = new Item(itemCode, itemPrice);
            Cart cart = new Cart(item, quantity);

            customerItems.add(cart);

            System.out.print("Do you want to add another item (Y/N)? ");
            addMoreItemsOption = scanner.next().charAt(0);
        } while (addMoreItemsOption == 'Y' || addMoreItemsOption == 'y');
        System.out.println();
    }


    private void payment() {
        if (isCartEmpty(customerItems)) {
            System.out.println("Please add items first to the Cart!!");
        } else {
            insertOrderItemsToDatabase(customerItems);
            CartItemsFromDb = getCartItemsFromDb(orderID);
            //billing(cartItems);
             billAmount = billing(orderID);
            System.out.println(formatReceiptData(CartItemsFromDb));
            System.out.println("*************************************");
            String currency = "KES";
            System.out.printf("%s %.2f\n", currency, billAmount);
            System.out.println("*************************************");

            try {
                System.out.print("Enter amount given by customer: ");
                amountGivenByCustomer = scanner.nextDouble();
                if (amountGivenByCustomer < billAmount) {
                    System.out.println("Invalid!!. Try a higher amount.");
                } else {
                    balance = amountGivenByCustomer - billAmount;
                    System.out.println("Change: " + balance);
                    updateOrderStatusToCompleted(orderID);
                    System.out.println();
                    System.out.println("*****************************");
                    System.out.println("THANK YOU FOR SHOPPING WITH US");
                    System.out.println("*****************************");
                    System.out.println();
                    customerItems.clear();
                }
            }catch (InputMismatchException ex){
               LOGGER.info("Amount Can only be an integer: " + ex.getMessage());
            }
        }
        System.out.println();
    }

    public void billing(@NotNull List<Cart> cartList) {
        for (Cart cart : cartList) {
            Item item = cart.getItem();
            int quantity = cart.getItemQuantity();
            double unitPrice = item.getItemPrice();
            double totalValue = unitPrice * quantity;
            billAmount += totalValue;
        }
        LOGGER.info("Billing Completed for order " + orderID + "!..");

    }
    public double billing(int order){
        double total =  getOrderTotalFromDb(orderID);
        LOGGER.info("Billing Completed for order " + orderID + "!..");
        return total;
    }


    public boolean isCartEmpty(List<Cart> cart) {
        return cart.isEmpty();
    }


    public String formatReceiptData(@NotNull List<Cart> itemsInCartList) {
        StringBuilder formattedReceiptData = new StringBuilder();
        formattedReceiptData.append(
                String.format("%-10s  %-9s  %-12s  %-12s%n", "Item Code", "Quantity", "Unit Price", "Total Value"));
        for (Cart cart : itemsInCartList) {
            Item item = cart.getItem();
            int quantity = cart.getItemQuantity();
            double unitPrice = item.getItemPrice();
            double totalValue = unitPrice * quantity;
            formattedReceiptData.append(String.format("%-11d  %4d  %12s  %12s%n", item.getId(), quantity,
                    String.format("%.2f", unitPrice), String.format("%.2f", totalValue)));
        }
        return formattedReceiptData.toString();
    }

    private void printReceipt() {
        if (isCartEmpty(CartItemsFromDb)) {
            System.out.println("Please add items first to the Cart!!");
        } else {
            System.out.println("**************RECEIPT********************");
            System.out.println(formatReceiptData(CartItemsFromDb));
            System.out.println("Total: KES " + billAmount);
            System.out.println("Cash Given: KES " + amountGivenByCustomer);
            System.out.println("Balance: KES " + balance);
            System.out.println("***********************************");
            System.out.println("THANK YOU FOR SHOPPING WITH SYSTECH");
            System.out.println("***********************************");
            System.out.println();
            LOGGER.info("Printing Receipt Completed.");

        }
    }

    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler("log.txt", true);
        FileLogger formatter = new FileLogger();
        LOGGER.addHandler(fileHandler);
        fileHandler.setFormatter(formatter);
        POSReviewed pos = new POSReviewed();
        Authentication authentication = new Authentication();
        createDatabaseTables();
        createUserInDatabase();

        boolean loggedIn = authentication.login();
        if (loggedIn) {
            System.out.println("Logged in successfully");

            while (true) {
                try {
                    pos.menu();
                } catch (Exception e) {
                    scanner.close();
                    LOGGER.severe("Internal Error: " + e.getMessage());
                    System.exit(-1);
                }
            }
        }
    }

}
