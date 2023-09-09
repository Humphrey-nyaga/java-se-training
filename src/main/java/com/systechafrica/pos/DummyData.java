package com.systechafrica.pos;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    public static List<Cart> cartList = new ArrayList<>();
    String currency = "KES";

    public void addItemToCart(Item item, int quantity) {
        Cart cart = new Cart(item, quantity);
        cartList.add(cart);
    }
    public void payment(List<Cart> cartList) {
        System.out.println("Item Code   Quantity   Unit Price   Total Value");
        double payableAmount = 0;
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

    }


    public static void main(String[] args) {
        Item item1 = new Item(1, "Item 1", 10.99);
        Item item2 = new Item(2, "Item 2", 7.49);
        Item item3 = new Item(3, "Item 3", 5.99);

        DummyData app = new DummyData();
        app.addItemToCart(item1,4);
        app.addItemToCart(item3,5);
        app.addItemToCart(item2,6);

        app.payment(cartList);
    }

}
