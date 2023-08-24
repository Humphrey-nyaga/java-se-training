
package com.systechafrica;

import com.systechafrica.LeapYear.LeapYear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearTest {
    LeapYear leapYear = new LeapYear();

    @Test
    public void YearIsDivisibleBy400(){
        int year = 2000;
        boolean isLeapExpected = true;
        Assertions.assertEquals(isLeapExpected, leapYear.isLeapYear(year));

    }

    @Test
    public void YearIsDivisibleBy4AndNotBy100(){
        int year = 2004;
        boolean isLeapExpected = true;
        Assertions.assertEquals(isLeapExpected, leapYear.isLeapYear(year));

    }
    @Test
    public void YearIsDivisibleBy4AndBy100(){
        int year = 1900;
        boolean isLeapExpected = false;
        Assertions.assertEquals(isLeapExpected, leapYear.isLeapYear(year));

    }

    @Test
    public void YearIsNotDivisibleByBoth4AndBy100(){
        int year = 1997;
        boolean isLeapExpected = false;
        Assertions.assertEquals(isLeapExpected, leapYear.isLeapYear(year));

    }






}
