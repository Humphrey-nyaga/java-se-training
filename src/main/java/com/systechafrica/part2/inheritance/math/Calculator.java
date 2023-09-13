package com.systechafrica.part2.inheritance.math;

//Method overloading
public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }
    public int sum(int a, int b, int c) { // number of parameters
        return a + b + c;
    } public int sum(int a, long b) { // different data types
        return a + (int)b;
    } public long sum(long a, long b) { // different return type
        return a + b;
    }

}
