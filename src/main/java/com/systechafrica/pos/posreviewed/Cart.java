package com.systechafrica.pos.posreviewed;

public class Cart {
    Item item;
    private int itemQuantity;


    public Cart(Item item, int itemQuantity) {
        this.item = item;
        this.itemQuantity = itemQuantity;
    }

    public Cart() {

    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "item=" + item +
                ", itemQuantity=" + itemQuantity +
                '}';
    }
}
