package com.systechafrica.part4.utildate;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class WorkingWithNewDate {
    public static void main(String[] args) {
//        workingWithLocalDate();
        //workingWithLocalDateTime();
      //  workingWithLocalTime();
        workingWithPeriods();
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
    private static void workingWithLocalTime(){
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime);
        System.out.println("localTime.plusHours(4) = " + localTime.plusHours(4));
        System.out.println("localTime.plusMinutes(35) = " + localTime.plusMinutes(35));
        System.out.println("localTime.plusSeconds(150) = " + localTime.plusSeconds(150));
    }
    private static void workingWithPeriods(){
        System.out.println("Working With Local Date and Period");
        LocalDate localDate = LocalDate.now();
        Period period = Period.ofYears(10);
        System.out.println("localDate.plus(period) = " + localDate.plus(period));
        System.out.println("localDate.minus(period) = " + localDate.minus(period));

        System.out.println("\nWorking With Time Duration");
        LocalTime localTime = LocalTime.now();
        Duration duration = Duration.ofHours(12);
        Duration duration1 = Duration.ofMinutes(30);
        System.out.println("localTime.plus(duration) = " + localTime.plus(duration));
        System.out.println("localTime.plus(duration1) = " + localTime.plus(duration1));
    }
}
