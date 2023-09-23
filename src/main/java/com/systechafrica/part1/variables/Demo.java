package com.systechafrica.part1.variables;

public class Demo {
    //instance method
    public int addTwoNumbers(int a, int b){
        return a + b;
    }
    // class method
    public static int add(int a, int b){
        return a + b;
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.addTwoNumbers(5, 2));
        System.out.println(add(5,2));

        //? whenever you are working with utility classes, you require
        //?
    }
}
