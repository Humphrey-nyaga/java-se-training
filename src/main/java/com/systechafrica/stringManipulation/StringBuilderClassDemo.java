package com.systechafrica.stringManipulation;

import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

public class StringBuilderClassDemo {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final Logger LOGGER = Logger.getLogger(StringBuilderClassDemo.class.getName());
    public void deleteStringBuilder(){
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to Java Programming");
        LOGGER.info("Original String before deletion: " + sb.toString());
        // deletion
        sb.delete(11, 15); // delete the word Java
        LOGGER.info("New String after deletion: " + sb.toString());
        sb.append(" in 2023!");// delete the word Java
        LOGGER.info("New String after new append: " + sb.toString());

    }
    public void insertStringBuilder(){
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to Programming");
        LOGGER.info("Original String before insert: " + sb.toString());
        sb.insert(10, " Scala");
        LOGGER.info("New String after insert: " + sb.toString());
    }
    public void replaceStringBuilder(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hello Software Engineers ");
        LOGGER.info("Original String before replacement: " + sb.toString());
        sb.replace(15,24, "Programmers");
        LOGGER.info("New String after replacement: " + sb.toString());
        LOGGER.info("Current capacity: " + sb.capacity());

    }

    public void stringBuilderSubstring(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hello Software Engineers ");
        LOGGER.info("Original String: " + sb.toString());
        LOGGER.info("Substring indices[0, 17]: " + sb.substring(6));
    }

    public void stringBuilderReverse(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hello Software Engineers ");
        LOGGER.info("Original String: " + sb.toString());
        sb.reverse();
        LOGGER.info("Reversed String: " + sb);

    }
    public void stringBuilderAppend(){
        StringBuilder sb = new StringBuilder();

        String fName = "Joe";
        String lName = "Doe";
        Date dob = new Date();
        String email = "joedoe@example.com";
        String gender = "Male";

        sb.append(fName)
                .append(" ")
                .append(lName)
                .append(" ")
                .append(dob)
                .append(" ")
                .append(email)
                .append(" ")
                .append(gender);
        LOGGER.info("User Info: " + sb);

    }
    public static void main(String[] args) {

     StringBuilderClassDemo app = new StringBuilderClassDemo();
    StringBuilder sb = new StringBuilder();
//    String str = "";
//    sb.append("Hello");
//
//    boolean equals = str.equals(sb.toString());
//    LOGGER.info("" + equals);

    // TODO
        //? delete, append, replace, insert
       // app.deleteStringBuilder();
        //app.insertStringBuilder();
       //app.replaceStringBuilder();
       // app.stringBuilderSubstring();
       // app.stringBuilderReverse();
        app.stringBuilderAppend();

    }
}
