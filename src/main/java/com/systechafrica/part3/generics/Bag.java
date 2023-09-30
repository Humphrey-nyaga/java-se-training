package com.systechafrica.pos.generics;

public class Bag {
    private String name;
    private String code;
    private int quantity;

    public Bag(String name, String code, int quantity) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
    }

    public Bag() {

    }

    @Override
    public String toString() {
        return "Bag{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
