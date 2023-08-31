package com.systechafrica.variables;

public class InstanceVsClassVariables {

    static String message = "Hello World!";
    String message2 = "Hello world";
    public void test(){
        System.out.println(message);
        System.out.println(message2);
    }
    public static void test2(){
        System.out.println(message);
        //! System.out.println(message2);
        //? Instance variables can only be accessed inside NON STATIC methods of the class.
        // They can only be accessed by use of their parent class instance.
    }
    public static void main(String[] args) {
        SampleClass app = new SampleClass();
        //?Access the class variables from a different class
        System.out.println("Class variable: " + SampleClass.name);

        //? Access an instance variables from a different class
        System.out.println(" Instance Variable: "+ app.age);


    }
}
