package com.systechafrica.pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class PointOfSale {
    private String currency = "KES";


    private static final Logger LOGGER = Logger.getLogger(PointOfSale.class.getName());
    Scanner scanner = new Scanner(System.in);
    private final List<Cart> cartList = new ArrayList<>();



    private void payment(double totalBillAmount) {
        System.out.print("\nEnter amount given by customer: ");
        double amountGivenByCustomer = scanner.nextDouble();
        if (amountGivenByCustomer < totalBillAmount) {
            System.out.println("Invalid!!. Try a higher amount.");
            System.out.println();
            menu();
        } else {
            double balance = amountGivenByCustomer - totalBillAmount;
            System.out.println("Change: " + balance);
            System.out.println();
            System.out.println("*****************************");
            System.out.println("THANK YOU FOR SHOPPING WITH US");
            System.out.println("*****************************");
        }
    }

    public void billing(List<Cart> cartList) {
        double payableAmount = 0;
        System.out.println("Item Code   Quantity   Unit Price   Total Value");
        for (Cart cart : cartList) {
            Item item = cart.getItem();
            int quantity = cart.getQuantity();
            double unitPrice = item.getItemPrice();
            double totalValue = unitPrice * quantity;
            payableAmount += totalValue;

            System.out.printf("%-11d %-10d  %s %-7.2f  %s %.2f%n", item.getId(), quantity, currency,unitPrice, currency,totalValue);
        }
        System.out.println("*************************************");
        System.out.printf("%s %.2f\n", currency,payableAmount);

        System.out.println("*************************************");
        payment(payableAmount);
    }


    private void addItem() {
        System.out.println("Add items to the cart:");
        char addMoreItemsOption;

        do {
            System.out.print("Enter Item Code: ");
            int itemCode = scanner.nextInt();
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
        menu();
    }
    public void menu(){
        System.out.println("*********************");
        System.out.println("SYSTECH POS SYSTEM");
        System.out.println("*********************");
        System.out.println(
                "1. ADD ITEM \n" +
                "2. MAKE PAYMENT \n" +
                "3. PRINT RECEIPT\n");

        System.out.println("Choose an option: ");
        int option = scanner.nextInt();
        switch (option){
            case 1 -> addItem();
            case 2 -> billing(cartList);
            case 3 -> printReceipt();
            default -> {
                System.out.println("Invalid Option");
                menu();
            }
        }
        scanner.nextLine();
    }

    private void printReceipt() {
    }

    public static void main(String[] args) {
        PointOfSale pos = new PointOfSale();
        Authentication authentication = new Authentication();
       if(authentication.login()){
           pos.menu();
       }else {
           System.exit(-1);
       }
    }
}
