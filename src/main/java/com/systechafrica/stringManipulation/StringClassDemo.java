package com.systechafrica.stringManipulation;

import com.systechafrica.looping.LoopingStatements;

import java.util.logging.Logger;

public class StringClassDemo {
    private static final Logger LOGGER = Logger.getLogger(StringClassDemo.class.getName());

    //? stringsa re immutable therefore cannot be modified once created
    //? unless they are reassigned
    public static void main(String[] args) {


    String message = "Hello ";
    //! no effect
    // has effect by reassigning
     LOGGER.info(message.concat("world"));
    String msg = message.concat("World");
    LOGGER.info(msg);

    //
    String sb = new String("Hello, world!");
    String sa = "Hello, world";
    boolean equals = sa.equals(sb);
    boolean equals2 = sa == sb;

    LOGGER.info(""+equals);
    LOGGER.info(""+equals2);

    //
        String ta = "A ";
        ta = ta.concat("B ");
        String tb = "C ";
        ta = ta.concat(tb);
        ta.replace("C", "D");
        ta = ta.concat(tb);
        LOGGER.info(ta);

    }
}
