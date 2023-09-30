package com.systechafrica.part3.generics.exercises;

/**Let's say you have an integer array and a string array.
 * You have to write a single method printArray that can print all the elements of both arrays.
 * The method should be able to accept both integer arrays or string arrays.
 */

 public class PrintList {
     public static <T> void printArray(T[] arr1){
         for ( T value: arr1) {
             System.out.println(value);
         }
     }

    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Fig"};
        Integer[] nums = {1, 2, 3, 4, 5};
        printArray(nums);
        printArray(fruits);
    }
}
