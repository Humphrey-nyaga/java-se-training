package com.systechafrica.part4.functionalprogramming;

@FunctionalInterface
public interface Calculator {
    abstract int calculate(int a, int b, int ...numbers);

}
