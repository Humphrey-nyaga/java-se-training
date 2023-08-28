package com.systechafrica.looping;

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
    public void breakJumpStatement(){
        LOGGER.info("Before My Loop");

        for(int index = 0; index <10; index++){
            if(index == 5){
                break;
            }
            LOGGER.info("my index is: " + index);
        }
        LOGGER.info("After My Loop");

    }
    public void continueJumpStatement(){
        LOGGER.info("Before My Loop");
        for(int index = 0; index <10; index++){
            if(index == 5){
                continue;
            }
            LOGGER.info("my index is: " + index);
        }
        LOGGER.info("After My Loop");

    }
    public void returnJumpStatement(){
        LOGGER.info("Before My Loop");
        for(int index = 0; index <10; index++){
            if(index == 5){
                return;
            }
            LOGGER.info("my index is: " + index);
        }
        LOGGER.info("After My Loop");

    }
    public static void main(String[] args) {
        LoopingStatements app = new LoopingStatements();
       // app.forLoop();
        //app.whileLoop();
        // app.doWhileloop();
        //app.breakJumpStatement();
        //app.continueJumpStatement();
        app.returnJumpStatement();
    }
}
