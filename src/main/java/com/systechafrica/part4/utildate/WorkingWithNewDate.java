package com.systechafrica.part4.utildate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class WorkingWithNewDate {
    public static void main(String[] args) {
//        workingWithLocalDate();
        workingWithLocalDateTime();
    }

    private static void workingWithLocalDate() {
        /*LocalDate is immutable
        * An addition or adjustment on a date must be reassigned
        * todayDate.plusDays(3); will not modify the date instead do as shown below
        * todayDate = todayDate.plusDays(3);
        * */
        LocalDate todayDate = LocalDate.now();
        System.out.println("todayDate = " + todayDate);

        //immutable unless date is reassigned
        todayDate.plusDays(3);

        // reassigning makes the plus changes stick
        todayDate = todayDate.plusDays(4);
        System.out.println("todayDate = todayDate.plusDays(4) = " + todayDate );
        System.out.println("todayDate.plusDays(5) = " + todayDate.plusDays(5));
        System.out.println("todayDate.plusMonths(3) = " + todayDate.plusMonths(3));
        System.out.println("todayDate.plusYears(2) = " + todayDate.plusYears(2));

        System.out.println("LocalDate.of(1997,3,20) = " + LocalDate.of(1997, 3, 20));
        System.out.println("LocalDate.of(1997, Month.MARCH,20) = " + LocalDate.of(1997, Month.MARCH, 20));
    }
    private static void workingWithLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);


        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("formatter.format(ISO_DATE_TIME) = " + formatter.format(localDateTime));
//        DateTimeFormatter formatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//        System.out.println("formatter1.format(ISO_LOCAL_DATE_TIME) = " + formatter1.format(localDateTime));

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("formatter3.format(ofPattern(\"yyyy-MM-dd\")) = " + formatter.format(localDateTime));

    }
}
