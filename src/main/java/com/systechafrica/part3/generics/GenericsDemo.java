package com.systechafrica.part3.generics;

public class GenericsDemo {
    public static void main(String[] args) {
        Storage<Bag> storage = new Storage<>();
        Bag bag = new Bag("Back Pack", "354",45);
        Bag bag1  = new Bag("Hand Bag","142", 89);
        Bag[] bags  = {bag1, bag};
        storage.store(bags);

        Storage<Product> productStorage = new Storage<>();
        Product product = new Product();
        Product product2 = new Product();
        Product[] products = {product,product2};
        productStorage.store(products);

        Bag bag3  = new Bag("Suitcase","198", 89);
        System.out.println(storage.store(bag3));

    }
}
