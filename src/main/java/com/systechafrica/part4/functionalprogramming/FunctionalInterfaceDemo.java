package com.systechafrica.part4.functionalprogramming;

import java.util.Arrays;

public class FunctionalInterfaceDemo{

    public static void main(String[] args) {
        FunctionalInterfaceDemo app = new FunctionalInterfaceDemo();
        app.functions(); 
    }

   
  public void functions(){

    Calculator calculator = (int a, int b, int...numbers) -> {
         return Arrays.stream(numbers)
                     .reduce(a + b, Integer::sum);
    };
    System.out.println("Sum of numbers is: " + calculator.calculate(100,100,100,100, 50));
   Calculator.divide(10,4);
}

}
