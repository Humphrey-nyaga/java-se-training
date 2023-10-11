package com.systechafrica.part4.lambda;


@FunctionalInterface
public interface GenerateReport<T, U> {
 void generateReport(T t, U u); // generic method  
}
