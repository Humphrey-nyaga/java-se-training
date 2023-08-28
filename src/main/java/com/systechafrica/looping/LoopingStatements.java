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
        for(int counter = 0; counter <= 10; counter = counter + 1){

            LOGGER.info("Count: " + counter);
        }  for(int counter = 0; counter <= 10; counter+=1){

            LOGGER.info("Count: " + counter);
        }
    }
    public void whileLoop(){
        int studentCount = 0;
        while(studentCount < 10){
            LOGGER.info("Student Count = " + studentCount);
            studentCount++;
        }

        // initialize condition  update

    }

    public void doWhileloop(){
        int counter = 0;
        int myNumber = 0;
        do {
            LOGGER.info("my number is: ");
            myNumber++;
            counter++;
        }
        while (myNumber<10);
            LOGGER.info("Counter: ");


    }
    public static void main(String[] args) {
        LoopingStatements app = new LoopingStatements();
       // app.forLoop();
        //app.whileLoop();
        app.doWhileloop();
    }
}
