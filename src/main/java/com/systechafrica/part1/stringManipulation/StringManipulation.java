package com.systechafrica.part1.stringManipulation;

import java.util.logging.Logger;

public class StringManipulation {
    private static final Logger LOGGER = Logger.getLogger(StringManipulation.class.getName());

    public void StringConcatWithOperator(){

        String str1 = "Hello";
        String str2 = " World";
        String str3 = str1 + str2;
        LOGGER.info("New concatenated string is: " + str3);
    }
    public void StringConcatWithConcatMethod(){

        String str1 = "Hello";
        String str2 = " Kenya";
        String str3 = str1.concat(str2);
        LOGGER.info("New concatenated string using concat method is: " + str3);
    }
    public void StringConcatWithStringBuilder() {
    String str1 = "Good morning";
    String str2 = "Software Engineers";
    StringBuilder str3 = new StringBuilder();
    str3.append(str1);
    LOGGER.info("New concatenated string using string builder is: " + str3);

    }

    public void checkStringEquality(){
        String str1 = "Java";
        String str2 = "Java";
        String str3 = "Introduction to Java";
        String str4 = "Introduction to Java";
        LOGGER.info("String 1 and String 2 are equal: " + str1.equals(str2));
        LOGGER.info("String 1 and String 3 are equal: " + str1.equals(str3));
        LOGGER.info("String 1 and String 4 are equal: " + str1.equals(str4));
    }

    public static void main(String[] args) {
        StringManipulation app = new StringManipulation();
        app.StringConcatWithOperator();
        app.StringConcatWithConcatMethod();
        app.checkStringEquality();
    }
}
