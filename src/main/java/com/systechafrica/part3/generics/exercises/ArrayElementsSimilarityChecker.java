package com.systechafrica.pos.generics.exercises;

import java.util.Arrays;
import java.util.List;

public class ArrayElementsSimilarityChecker<U, V> {

    public boolean arraysAreSimilar(U[] arr1, V[] arr2) {
        if (arr1.getClass().componentType() == arr2.getClass().componentType()) {
            return Arrays.equals(arr1, arr2);
        } else {
            System.out.println("Arrays Not similar type!!");
            return false;
        }
    }
    public void arraysInGenericClass(){
        ArrayElementsSimilarityChecker<Integer, Integer> checker = new ArrayElementsSimilarityChecker<>();

        Integer[] intArray1 = {1, 2, 3, 4, 5};
        Integer[] intArray2 = {1, 2, 3, 4, 5};

        Integer[] intArray3 = {1, 2, 3, 4, 5};
        Integer[] intArray4 = {12, 2, 43, 4, 45};

        Double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0};

        boolean areSimilar1 = checker.arraysAreSimilar(intArray1, intArray2);

        ArrayElementsSimilarityChecker<Integer, Double> checker2 = new ArrayElementsSimilarityChecker<>();
        boolean areSimilar2 = checker2.arraysAreSimilar(intArray3, doubleArray);
        boolean areSimilar3 = checker.arraysAreSimilar(intArray3, intArray4);

        System.out.println("Are intArray1 and intArray2 similar: " + areSimilar1);
        System.out.println("Are intArray1 and doubleArray similar: " + areSimilar2);
        System.out.println("Are intArray3 and intArray4 similar: " + areSimilar3);

    }

    public static <T extends Number> void evenAndOddNumbersSum(List<T> numbers){

        double evenSum = 0;
        double oddSum = 0;

        for (T t: numbers) {
            if(t.doubleValue() %2 == 0){
                evenSum += t.doubleValue();
            } else{
                oddSum += t.doubleValue();
            }
        }

        System.out.println("Even Sum: " + evenSum);
        System.out.println("Odd Sum: " + oddSum);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(45,45,90,180);
        evenAndOddNumbersSum(nums);

        List<Double> nums2 = List.of(22.0,45.1,90.9,180.2);
        evenAndOddNumbersSum(nums2);

    }
}

