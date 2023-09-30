package com.systechafrica.part3.generics;

public class ImmutableArray<T> {

    private final T[] items;

    public ImmutableArray(T[] items) {
        this.items = items.clone();
    }

    public T get(int index) {
        return items[index];
    }

    public int length() {
        return items.length;
    }

    public static void main(String[] args) {
        var fruits = new ImmutableArray<>(new String[] {"Mango", "Apple", "Orange"});

        for (int i = 0; i < fruits.length(); i++) {
            System.out.print(fruits.get(i) + " ");
        }

    }
}
