package com.systechafrica.part2.accessmodifiers;

public class Person {
    private String name;
    private String email;
    private boolean promoted;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
    //setters and getters

    public Person() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printPersonalDetails() {
        System.out.println(getPersonDetails());
    }

    private String getPersonDetails() {
        return email + " " + name;
    }
}
