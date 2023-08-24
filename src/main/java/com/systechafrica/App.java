package com.systechafrica;

import com.systechafrica.variables.VariablesDemo;

import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Hello World!");

    }

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {return a - b;}

    public int difference(int a, int b) {
        if(b > a){
            return b - a;
        }
        return a - b;
    }
}
