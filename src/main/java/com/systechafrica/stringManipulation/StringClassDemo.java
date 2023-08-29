package com.systechafrica.stringManipulation;

import com.systechafrica.looping.LoopingStatements;

import java.util.logging.Logger;

public class StringClassDemo {
    private static final Logger LOGGER = Logger.getLogger(StringClassDemo.class.getName());

    //? stringsa re immutable therefore cannot be modified once created
    //? unless they are reassigned

    String message = "Hello ";
    //! no effect
    // has effect by reassigning
    String msg = message.concat("World");
}
