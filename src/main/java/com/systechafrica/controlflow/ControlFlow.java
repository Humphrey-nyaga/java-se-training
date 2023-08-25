package com.systechafrica.controlflow;

import com.systechafrica.operators.OperatorsDemo;

import java.util.logging.Logger;

public class ControlFlow {
    private static final Logger LOGGER = Logger.getLogger(ControlFlow.class.getName());
    public void ifElseStatement(){
        int maths = 29;
        char grade;
        if(maths >= 70) {
            grade = 'A';
        }
        else if (maths<= 69 && maths >59) {
            grade = 'B';
        }
        else if (maths<= 59 && maths > 49) {
            grade = 'C';
        } else if (maths <= 49 && maths > 39) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }
        LOGGER.info("Student Grade: " + grade);
    }
    public void swithStatement(){
        String day = "FRIDAY";
        switch(day){
            case "MONDAY":
                LOGGER.info("Monday working day");
                break;
            case "TUESDAY":
                LOGGER.info("Tuesday working day");
                break;
            case "WEDNESDAY":
                LOGGER.info("Wednesday working day");
                break;
            case "THURSDAY":
                LOGGER.info("Thursday working day");
                break;
            case "FRIDAY":
                LOGGER.info("Friday working day");
                break;
            case "SATURDAY":
            case "SUNDAY":
                LOGGER.info("Sherehe");
            default:
                LOGGER.info("Please specify a valid day");

        }

    }
    public static void main(String[] args) {
        ControlFlow app = new ControlFlow();
        //app.ifElseStatement();
        app.swithStatement();

    }
}
