package com.systechafrica.part4.utildate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class WorkingWithUtilDate {
    public static void main(String[] args) {

        Date todayDate = new Date();
        System.out.println("date = " + todayDate);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,2);
        // add two days to the date
        System.out.println("calendar.getTime() = " + calendar.getTime());
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter date: ");
            String dateString = scanner.nextLine();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Date tomorrowDate = dateFormat.parse(dateString);
            System.out.println("tomorrowDate.getTime() = " + tomorrowDate.getTime());
            System.out.println("dateFormat.format(tomorrowDate) = " + dateFormat.format(tomorrowDate));
            System.out.println("df.format(tomorrowDate) = " + df.format(tomorrowDate));

            System.out.println("tomorrowDate.before(todayDate) = " + tomorrowDate.before(todayDate));
            System.out.println("tomorrowDate.after(todayDate) = " + tomorrowDate.after(todayDate));

            if(tomorrowDate.after(todayDate)){
                System.out.println("Valid Date");
            }else{
                System.out.println("Please use a valid date");
            }
        }catch (Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

    }
}
