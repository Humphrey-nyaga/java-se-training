package com.systechafrica.part4.functionalprogramming.supplier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class SupplierDemo {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        Supplier<LocalDateTime> localDateTime = () -> LocalDateTime.now();
        LocalDateTime time = localDateTime.get();

        System.out.println(time);

        Supplier<String> formattedLocalDateTime = () -> dtf.format(LocalDateTime.now());
        String time2 = formattedLocalDateTime.get();

        System.out.println(time2);
    }
}
