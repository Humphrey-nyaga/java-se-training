package com.systechafrica.stringManipulation;

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
        app.deleteStringBuilder();

    }
}
