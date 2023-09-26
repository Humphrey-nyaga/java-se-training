package com.systechafrica.pos.posreviewed;

import com.systechafrica.part3.logging.CustomLogFormatter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static com.systechafrica.pos.posreviewed.Utils.*;

public class POSReviewed {
    private static final Logger LOGGER = Logger.getLogger(POSReviewed.class.getName());


    private List<Cart> cartList = new ArrayList<>();
    private List<Cart> receiptItemsList =new ArrayList<>();
    private double receiptBillAmount =0;
    static Scanner scanner = new Scanner(System.in);
    private double totalBillAmount = 0;
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

            cartList.add(cart);

            System.out.print("Do you want to add another item (Y/N)? ");
            addMoreItemsOption = scanner.next().charAt(0);
        } while (addMoreItemsOption == 'Y' || addMoreItemsOption == 'y');
        System.out.println();
    }

    public void billing(@NotNull List<Cart> cartList) {
        //System.out.printf("%-10s  %-10s  %-9s  %-12s  %-12s%n", "Item Code", "Item Name", "Quantity", "Unit Price", "Total Value");
        for (Cart cart : cartList) {
            Item item = cart.getItem();
            int quantity = cart.getItemQuantity();
            double unitPrice = item.getItemPrice();
            double totalValue = unitPrice * quantity;
            totalBillAmount += totalValue;

            // System.out.printf("%-11d  %-10s  %4d  %12s  %12s%n", item.getId(), itemName, quantity, String.format("%.2f", unitPrice), String.format(" %.2f", totalValue));
        }
        LOGGER.info("Billing successful \n");

    }

    public boolean isCartEmpty(List<Cart> cart) {
        return cart.isEmpty();
    }

    private void payment() {
        if (isCartEmpty(cartList)) {
            System.out.println("Please add items first to the Cart!!");
        } else {
            //TODO After user decides to make a payment, create the order and add the items to the database
            insertOrderItemsToDatabase(cartList);
            billing(cartList);
            double billAmount = totalBillAmount;
            System.out.println(formatReceiptData(cartList));
            System.out.println("*************************************");
            String currency = "KES";
            System.out.printf("%s %.2f\n", currency, billAmount);
            System.out.println("*************************************");

            System.out.print("Enter amount given by customer: ");
            amountGivenByCustomer = scanner.nextDouble();
            if (amountGivenByCustomer < billAmount) {
                System.out.println("Invalid!!. Try a higher amount.");
            } else {
                balance = amountGivenByCustomer - billAmount;
                System.out.println("Change: " + balance);
                System.out.println();
                System.out.println("*****************************");
                System.out.println("THANK YOU FOR SHOPPING WITH US");
                System.out.println("*****************************");
                System.out.println();

                /*
                 *We need to copy the current list @cartList before we clear it
                 * so that incase a user opts to print a receipt, we use the @receiptItemsList
                 * and if they do not print they receipt and decide to add a new item for new customer
                 * we find the @cartList empty
                 * */
                receiptItemsList.clear();
                receiptItemsList = new ArrayList<>(List.copyOf(cartList));
                receiptBillAmount = totalBillAmount;
                totalBillAmount = 0;
                cartList.clear();
            }
        }
        System.out.println();

    }

    public String formatReceiptData(@NotNull List<Cart> itemsInCartList) {
        StringBuilder formattedReceiptData = new StringBuilder();
        formattedReceiptData.append(String.format("%-10s  %-9s  %-12s  %-12s%n", "Item Code", "Quantity", "Unit Price", "Total Value"));
        for (Cart cart : itemsInCartList) {
            Item item = cart.getItem();
            int quantity = cart.getItemQuantity();
            double unitPrice = item.getItemPrice();
            double totalValue = unitPrice * quantity;
            formattedReceiptData.append(String.format("%-11d  %4d  %12s  %12s%n", item.getId(), quantity, String.format("%.2f", unitPrice), String.format("%.2f", totalValue)));
        }
        return formattedReceiptData.toString();
    }

    private void printReceipt() {
        if (isCartEmpty(receiptItemsList)) {
            System.out.println("Please add items first to the Cart!!");
        } else {

            double billAmount = receiptBillAmount;
            System.out.println("**************RECEIPT********************");
            System.out.println(formatReceiptData(receiptItemsList));
            System.out.println("Total: KES " + billAmount);
            System.out.println("Cash Given: KES " + amountGivenByCustomer);
            System.out.println("Balance: KES " + balance);
            System.out.println("***********************************");
            System.out.println("THANK YOU FOR SHOPPING WITH SYSTECH");
            System.out.println("***********************************");
            System.out.println();
            LOGGER.info("Printing Receipt Completed...\n");

        }
        receiptItemsList.clear();
    }

    public static void main(String[] args) throws IOException {
        createDatabaseTables();
        createUserInDatabase();
        FileHandler fileHandler = new FileHandler("log.txt");
        CustomLogFormatter formatter = new CustomLogFormatter();
        LOGGER.addHandler(fileHandler);
        fileHandler.setFormatter(formatter);

        POSReviewed pos = new POSReviewed();
        Authentication authentication = new Authentication();
        boolean loggedIn = authentication.login();
        if (loggedIn) {
            System.out.println("Logged in successfully");
            while (true) {
                pos.menu();
                try {
                    System.out.print("Choose an option: ");
                    int option = scanner.nextInt();
                    switch (option) {
                        case 1 -> pos.addItem();
                        case 2 -> pos.payment();
                        case 3 -> pos.printReceipt();
                        case 4 -> System.exit(-1);
                        default -> System.out.println("Invalid Option");
                    }
                    scanner.nextLine();
                }
                catch (Exception e) {
                    scanner.close();
                    System.exit(-1);
                    LOGGER.severe("Internal Error: " + e.getMessage() + "\n");
                }
            }
        }

    }
}
