package com.systechafrica.arrays;

import com.systechafrica.stringManipulation.StringBuilderClassDemo;

import java.util.logging.Logger;

public class WorkingWithArrays {
    private static final Logger LOGGER = Logger.getLogger(WorkingWithArrays.class.getName());
    public void singleDimensionalArray() {
        int[] numbers = {45, 10, 26, 35, 40, 59};
        String[] nicknames = {"Mhusika", "Ntate", "Yokana"};
        for (int number : numbers) {
            LOGGER.info("" + number);
        }
    }
    public static void main(String [] args){
        WorkingWithArrays app = new WorkingWithArrays();
        app.singleDimensionalArray();

    }
}
