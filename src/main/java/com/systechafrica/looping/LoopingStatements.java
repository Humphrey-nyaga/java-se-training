package com.systechafrica.looping;

import com.systechafrica.controlflow.ControlFlow;

import java.util.logging.Logger;

public class LoopingStatements {
    private static final Logger LOGGER = Logger.getLogger(LoopingStatements.class.getName());

    public void forLoop(){

        // initialize condition  update
        for(int counter = 0; counter <= 10; counter++){

            LOGGER.info("Count: " + counter);
        }
    }
    public static void main(String[] args) {
        LoopingStatements app = new LoopingStatements();
        app.forLoop();
    }
}
