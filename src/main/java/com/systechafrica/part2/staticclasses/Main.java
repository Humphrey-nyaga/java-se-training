package com.systechafrica.part2.staticclasses;

import static com.systechafrica.part2.staticclasses.MathUtils.Calculator.modulus;
import static com.systechafrica.part2.staticclasses.MathUtils.Calculator.sum;

public class Main {
    public static void main(String[] args) {
        System.out.println(ATMUtils.maskCardNumber("1234567890659877"));
        int a = 14;
        int b = 79;

        System.out.println("sum: "  + sum(a,b));
        System.out.println("modulus: "  + modulus(a,b));

        String testString = "  Hello KE  ";
        System.out.println(StringUtils.length(testString));
        System.out.println(StringUtils.trimWhiteSpaces(testString));
        System.out.println(StringUtils.length(testString));
        System.out.println(StringUtils.isNullOrEmpty(testString));
        System.out.println(StringUtils.isEmpty(testString));




    }
}
