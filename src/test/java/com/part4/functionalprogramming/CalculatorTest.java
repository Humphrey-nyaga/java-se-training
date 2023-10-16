package com.part4.functionalprogramming;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.systechafrica.part4.functionalprogramming.Calculator;

class CalculatorTest {

    Calculator calculator = (a, b, numbers) -> {
        int sum = a + b;
        /*
         * numbers is an int array.
         * Instead of using a for each loop to iterate items,
         * use .boxed() to return a list of Integer objects
         */
        List<Integer> nums = Arrays.stream(numbers).boxed().toList();
        return nums.stream()
                .reduce(sum, Integer::sum);
    };

    @Test
    @DisplayName("Test calculation using calculate method")
    void testSum() {
      
        // then
        Assertions.assertAll(
            ()-> Assertions.assertEquals(14, calculator.calculate(7, 7), "expected result should match" ),
            ()-> Assertions.assertEquals(120, calculator.calculate(10, 10,20, 10, 20, 50), "expected result should match" ),
            ()-> Assertions.assertEquals(100, calculator.calculate(0, 0,20, 10, 20, 50), "expected result should match" ),
            ()-> Assertions.assertEquals(14, calculator.calculate(7, 7), "expected result should match" )
        );
    }

}
