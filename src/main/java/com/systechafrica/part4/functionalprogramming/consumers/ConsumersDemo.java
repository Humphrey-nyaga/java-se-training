package com.systechafrica.part4.functionalprogramming.consumers;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumersDemo {
    public static void main(String[] args) {
        // list
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> integerStream = integers.stream();

        // intermediary operations filter
        Stream<Integer> filteredStream = integerStream.filter(number -> number % 2 != 0);
        // intermediary operations map
        Stream<Integer> mappedStream = filteredStream.map(number -> number * 2);

        // terminating operation
        // ? Consumer receives a single input but returns no result
        Consumer<Integer> integerConsumer = number -> System.out.println(number);
        ;
        mappedStream.forEach(integerConsumer);

        BiConsumer<Integer, Integer> biConsumber = (a, b) -> printInfo(a, b);
        biConsumber.accept(25, 15); // perform the operation

        List<String> continentList = Arrays.asList("Europe","Africa","South America","Asia","Australia");
        
        // we can call the forEachDoSOmething method in two ways.
        // Method 1
        System.out.println("/nInitializing a cosnumer before using it");
        Consumer<String>continentConsumer = country -> System.out.println(country);
        forEachDoSomething(continentList, continentConsumer);

        /// method 2 
        System.out.println("Calling a consumer inline");
        forEachDoSomething(continentList,(String country)-> System.out.println(country));
    }

    private static void printInfo(Integer a, Integer b) {
        System.out.println(a + " * " + b + " = " + a * b);
    }

    static <T> void forEachDoSomething(List<T> list, Consumer<? super T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
    /*
     * Predicate -> boolean test(t t)
     * BiPredicate -> boolean test(T t, U u)
     * 
     * Function -> R apply(T t)
     * BiFunction -> R apply(T t, U u)
     * 
     * 
     * Consumer -> void accept(T t)
     * BiConsumer -> void accept(T t, U u)
     */

}
