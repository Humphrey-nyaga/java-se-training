package com.systechafrica.part4.functionalprogramming;

@FunctionalInterface
public interface Calculator {
    abstract int calculate(int a, int b, int... numbers);

    static int divide(int a, int b) {
        return a / b;
    }

    static int modulus(int a, int b) {
        return a % b;
    }
}
