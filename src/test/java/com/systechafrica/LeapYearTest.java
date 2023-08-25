
package com.systechafrica;

import com.systechafrica.LeapYear.LeapYear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearTest {
    LeapYear leapYear = new LeapYear();

    @Test
    public void YearIsDivisibleBy400(){
        Assertions.assertTrue( leapYear.isLeapYear(2000));
    }

    @Test
    public void YearIsDivisibleBy4AndNotBy100(){
        Assertions.assertTrue(leapYear.isLeapYear(2004));
    }
    @Test
    public void YearIsDivisibleBy4AndBy100(){
        Assertions.assertFalse( leapYear.isLeapYear(1900));
    }

    @Test
    public void YearIsNotDivisibleByBoth4AndBy100(){
        Assertions.assertFalse(leapYear.isLeapYear(1997));
    }

}
