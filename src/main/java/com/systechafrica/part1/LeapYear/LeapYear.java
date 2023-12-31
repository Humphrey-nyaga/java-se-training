package com.systechafrica.part1.LeapYear;

import java.util.Scanner;

public class LeapYear {

    public boolean isLeapYear(int year){
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a year: ");
        int year = scan.nextInt();
        LeapYear leapYear = new LeapYear();
        System.out.println("Is the year " + year + " a leap year?" + leapYear.isLeapYear(year));


    }
}
