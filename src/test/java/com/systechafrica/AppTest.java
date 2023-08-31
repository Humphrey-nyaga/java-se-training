package com.systechafrica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //? default instance
public class AppTest {

    //? Reference => App
    App app = new App();
    @Test
    void add(){
        //when
        int result = app.add(2, 3);
        //then
        int expected = 5;
        //verify that result = expected
        Assertions.assertEquals(expected, result, " the sum of 2 + 3 should be 5");
    }

    @Test
    void subtract(){
        int result = app.subtract(4, 2);
        int expected = 2;
        Assertions.assertEquals(expected, result ,"The difference between 4 and 2 should be 2");
    }

    @Test
    void difference(){
        int result = app.difference(4, 23);
        int expected = 19;
        Assertions.assertEquals(expected, result ,"The difference between 4 and 23 should be 19");
    }
}

