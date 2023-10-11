package com.systechafrica.part4.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumersDemo {
    public static void main(String[] args) {

        List<String> listVal = Arrays.asList("Joe", "Paul","Alice","Tom");
        var x =listVal.stream().filter(name -> name.length()>3)
        .count();
        System.out.println("Count of streams" + x);

        List<Integer> integers = List.of(4, 3, 2, 5, 6, 3, 12, 78, 6, 3, 1);

        // stream
        Stream<Integer> integerStream = integers.stream();

        // intermediary operations
        Stream<Integer> filteredStream = integerStream.filter(number -> number % 2 != 0);
        // intermediary operation
        Stream<Integer> mappedStream = filteredStream.map(number -> number * 2);

        // terminating stream
        Consumer<Integer> integerConsumer = number -> System.out.println(number);
        mappedStream.forEach(integerConsumer);

    }
}
