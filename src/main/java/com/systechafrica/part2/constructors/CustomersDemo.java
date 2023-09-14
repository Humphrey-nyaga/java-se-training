package com.systechafrica.part2.constructors;

public class CustomersDemo {
    public static void main(String[] args) {
        Book b1 = new Book(2022, "Introduction",true);
        Book b2 = new Book(2022, "Introduction",true);

        if(b1.equals(b2)){
            System.out.println("Are equal");
        } else{
            System.out.println("Not equal");
        }
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
    }
}
