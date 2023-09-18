package com.systechafrica.part2.staticclasses;

public class ATMUtils {
    public static String maskCardNumber(String cardNumber){
        String mask = "XXXX-XXXX-XXXX-";
        String infix = cardNumber.substring(12);
        return mask + infix;
    }
}
