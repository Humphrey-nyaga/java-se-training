package com.systechafrica.pos;

import java.util.logging.Logger;

public class Item {
    private static final Logger LOGGER = Logger.getLogger(Item.class.getName());

    private int id;
    private double itemPrice;

    public Item(int id, double itemPrice) {
        this.id = id;
        this.itemPrice = itemPrice;
    }

    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
