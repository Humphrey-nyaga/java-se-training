package com.systechafrica.stringManipulation;

import java.util.logging.Logger;

public class StringBuilderClassDemo {
    private static final Logger LOGGER = Logger.getLogger(StringBuilderClassDemo.class.getName());

    public static void main(String[] args) {


    StringBuilder sb = new StringBuilder(100);
    String str = "";
    sb.append("Hello");

    boolean equals = str.equals(sb.toString());
    LOGGER.info("" + equals);

    // TODO
        //? delete, append, replace, insert
    }
}
