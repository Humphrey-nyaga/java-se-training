package com.systechafrica.part4.functionalprogramming;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionalProgrammingDemo {
    public static void functions() {
        Calculator calculator2 = (a, b, numbers) -> {
            int sum = a + b;
            for (int num : numbers) {
                sum += num;
            }
            return sum;
        };

        System.out.println(calculator2.calculate(45, 90));
        System.out.println(calculator2.calculate(10, 90, 40, 70, 45, 90));

    }

    public static void lambdaInFunction() {
        List<Integer> integers = List.of(10, 15, 35, 65, 23, 56);
        integers.forEach(number -> System.out.println(number));

    }

    public static void filterAndMapNormalWay() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();
        // stream.filter(number->evenNumbers(number));
        Stream<Integer> filteredEvenNumbers = numbers.stream().filter(number -> number % 2 == 0);

        // map-> transformation
        // Stream<Integer>squareIntegerStream =
        // filteredEvenNumbers.map(number->mapToSquare(number));
        Stream<Integer> squareIntegerStream = filteredEvenNumbers.map(number -> number * number);

        // display final product
        squareIntegerStream.forEach(number -> System.out.println(number));
    }

    public static boolean evenNumbers(int num) {
        return num % 2 == 0;
    }

    public static int mapToSquare(int n) {
        return n * n;
    }

    public static void printInfo(List<Integer> list, Predicate<Integer> evenNumberFunction) {
        list.stream().filter(evenNumberFunction)
                .forEach(n -> System.out.println(n));
    }

    public static void filterAndMapChain() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .forEach(number -> System.out.println(number));
        Predicate<Integer> evenFunctionFilter = number -> number % 2 == 0;
        printInfo(numbers, evenFunctionFilter);
    }

    public static void countEvenNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long count = numbers.stream()
                .filter(number -> number % 2 == 0).count();
        System.out.println("Even Numbers Count = " + count);
    }

    public static void main(String[] args) {
        // functions();
        // lambdaInFunction();
        /// filterAndMapNormalWay();
        // filterAndMapChain();
        countEvenNumbers();

    }
}
