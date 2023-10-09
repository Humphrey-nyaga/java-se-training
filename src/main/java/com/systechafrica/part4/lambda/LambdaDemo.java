package com.systechafrica.part4.lambda;

import java.util.function.Function;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class LambdaDemo {
    public static void printResultOfLambda(Function<String, Integer> function) {
        System.out.println(function.apply("HAPPY NEW YEAR 3000!"));
    }

    static Function<List<Integer>, Integer> maxFunction = list -> {
        return list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    };

    public static void workWithBiFunctions() {
        BiFunction<Integer, Integer, Integer> multiplier = (a, b) -> a * b;

        System.out.println(multiplier.apply(45, 95));
        System.out.println(multiplier.apply(5, 200));
        System.out.println(multiplier.apply(20, 20));
    }

    public static void test(Function<List<Integer>, Integer> function) {
        List<Integer> nums = Arrays.asList(35, 22, 92, 11, -8);
        System.out.println(function.apply(nums));

    }

    public static void main(String[] args) {
        Function<String, Integer> counter = s -> s.length();
        printResultOfLambda(counter);
        workWithBiFunctions();
        test(maxFunction);

    }

}