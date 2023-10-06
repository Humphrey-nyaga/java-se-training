package com.systechafrica.part2.accessmodifiers;

public class AccessModifiersDemo {

    public static void main(String[] args) {
        Person person2 = new Person("John Doe", "johndoe@example.com");
        person2.printPersonalDetails();

        Person person = new Person();
        person.setName("Smith Doe");
        person.setEmail("Smithdoe@example.com");

        System.out.println("Name is: " + person.getName() + " and Email: " + person.getEmail());
    }
}
