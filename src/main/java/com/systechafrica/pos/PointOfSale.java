package com.systechafrica.pos;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PointOfSale {
    private List<Cart> cartList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    private double totalBillAmount = 0;
    private double amountGivenByCustomer = 0;
    private double balance = 0;

    public void menu() {
        System.out.println("*********************");
        System.out.println("SYSTECH POS SYSTEM");
        System.out.println("*********************");
        System.out.println(
                """
                        1. ADD ITEM\s
                        2. MAKE PAYMENT\s
                        3. PRINT RECEIPT
                        """);

        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> addItem();
            case 2 -> payment();
            case 3 -> printReceipt();
            default -> {
                System.out.println("Invalid Option");
                menu();
            }
        }
        scanner.nextLine();
    }

    private void addItem() {
        System.out.println("Add items to the cart:");
        char addMoreItemsOption;

        do {
            System.out.print("Enter Item Code: ");
            int itemCode;
            itemCode = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Item Name: ");
            String itemName = scanner.nextLine();
            System.out.print("Enter Item price: ");
            double itemPrice = scanner.nextDouble();
            System.out.print("Enter Item quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            Item item = new Item(itemCode, itemName, itemPrice);
            Cart cart = new Cart(item, quantity);

            cartList.add(cart);

            System.out.print("Do you want to add another item (Y/N)? ");
            addMoreItemsOption = scanner.next().charAt(0);
        } while (addMoreItemsOption == 'Y' || addMoreItemsOption == 'y');
        System.out.println();
        menu();
    }

    public double billing(@NotNull List<Cart> cartList) {
        //System.out.printf("%-10s  %-10s  %-9s  %-12s  %-12s%n", "Item Code", "Item Name", "Quantity", "Unit Price", "Total Value");
        for (Cart cart : cartList) {
            Item item = cart.getItem();
            int quantity = cart.getItemQuantity();
            double unitPrice = item.getItemPrice();
            double totalValue = unitPrice * quantity;
            totalBillAmount += totalValue;

            // System.out.printf("%-11d  %-10s  %4d  %12s  %12s%n", item.getId(), itemName, quantity, String.format("%.2f", unitPrice), String.format(" %.2f", totalValue));
        }
        return (totalBillAmount);

    }

    public boolean isCartEmpty() {
        return cartList.isEmpty();
    }

    private void payment() {
        double billAmount = billing(cartList);
        if (isCartEmpty()) {
            System.out.println("Please add items first to the Cart!!");
        } else {
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
            }
        }
        System.out.println();
        menu();

    }

    public String formatReceiptData(@NotNull List<Cart> itemsInCartList) {
        StringBuilder formattedReceiptData = new StringBuilder();
        formattedReceiptData.append(String.format("%-10s  %-10s  %-9s  %-12s  %-12s%n", "Item Code", "Item Name", "Quantity", "Unit Price", "Total Value"));
        for (Cart cart : itemsInCartList) {
            Item item = cart.getItem();
            int quantity = cart.getItemQuantity();
            String itemName = item.getItemName();
            double unitPrice = item.getItemPrice();
            double totalValue = unitPrice * quantity;
            formattedReceiptData.append(String.format("%-11d  %-10s  %4d  %12s  %12s%n", item.getId(), itemName, quantity, String.format("%.2f", unitPrice), String.format("%.2f", totalValue)));
        }
        return formattedReceiptData.toString();
    }

    private void printReceipt() {
        if (isCartEmpty()) {
            System.out.println("Please add items first to the Cart!!");
        } else {
            double billAmount = totalBillAmount;
            System.out.println("**************RECEIPT********************");
            System.out.println(formatReceiptData(cartList));
            System.out.println("Total: KES " + billAmount);
            System.out.println("Cash Given: KES " + amountGivenByCustomer);
            System.out.println("Balance: KES " + balance);
            System.out.println("***********************************");
            System.out.println("THANK YOU FOR SHOPPING WITH SYSTECH");
            System.out.println("***********************************");
            System.out.println();
        }
        cartList.clear();
        menu();
    }

    public static void main(String[] args) {
        PointOfSale pos = new PointOfSale();
        Authentication authentication = new Authentication();
        if (authentication.login()) {
            pos.menu();
        } else {
            System.exit(-1);
        }
    }

}
