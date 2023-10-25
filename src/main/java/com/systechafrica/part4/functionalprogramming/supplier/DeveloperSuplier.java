package com.systechafrica.part4.functionalprogramming.supplier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Supplier;

public class DeveloperSuplier {
    public static void main(String[] args) {
        Developer dev1 = developerFactory(Developer::new);
        System.out.println(dev1);

        Developer dev2 = developerFactory(() -> new Developer("John Doe",BigDecimal.valueOf(190_989.0)));
        System.out.println(dev2);
        
    }
    public static Developer developerFactory(Supplier<? extends Developer> s){
        Developer developer = s.get();
        if (developer.getName() == null || developer.getName().isEmpty()) {
            developer.setName("default");
            developer.setSalary(BigDecimal.TEN);
        }
        developer.setStart(LocalDate.now());

        return developer;
    }
}
