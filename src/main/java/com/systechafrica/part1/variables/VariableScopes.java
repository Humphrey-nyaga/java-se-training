package com.systechafrica.part1.variables;

import java.util.logging.Logger;

public class VariableScopes {
    private static final Logger LOGGER = Logger.getLogger(VariableScopes.class.getName());

    //class variables => they are defined as variables and declared outside any class method
    //class scope variables
    private int matchesPlayed = 3;
    public void simpleMethod(){
        LOGGER.info("simple method output: "+matchesPlayed);
    }
    public void complexMethod(){
        LOGGER.info("complex method output: " + matchesPlayed);
    }
    public int addTwoNumbers(int a, int b){ //method variable scope => variables
        // declared as parameters in the outermost part of the method.
        int result = a + b;

        for (int i = 0; i < 5; i++) {
            LOGGER.info("method output: " + i);
        }
        return result;
    }

    public static void main(String[] args) {
        VariableScopes app = new VariableScopes();
        app.complexMethod();
        app.simpleMethod();
        app.addTwoNumbers(5,3);
        LOGGER.info("main method output: " + app.matchesPlayed);

    }
}
