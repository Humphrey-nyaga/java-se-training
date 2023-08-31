package com.systechafrica;

import java.util.Scanner;

public class Calculator {
    public int sum(int a , int b, int ...otherNumber){ //!Variable arguments
        int sum = a + b;
        for (int i = 0; i < otherNumber.length ; i++) {
            sum += otherNumber[i];
        }
        return sum;
    }
    public static void main(String[] args) {
       Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a list of space separated numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(calculator.sum(10,20,10,10,10,10,10));

    }
}
