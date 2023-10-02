package com.systechafrica.part3.collections;

import java.util.LinkedList;

public class WorkingWithLinkedList {
    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Cow");
        animals.add("Horse");
        animals.add("Goat");

        System.out.println("animals.getFirst() = " + animals.getFirst());
        System.out.println("animals.getLast() = " + animals.getLast());
        System.out.println("animals.get(1) = " + animals.get(1));
        System.out.println("animals.remove(2) = " + animals.remove(2));
        System.out.println("animals = " + animals);
        animals.set(2,"Ostrich");
        System.out.println("animals = " + animals);

    }
}
