package com.systechafrica.part4.functionalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringAndMapping {
    public static void main(String[] args) {

        // workingWithStreamsAndCOllector();

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum = " + sum);
        int product = numbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(0, (a, b) -> a * b);
        System.out.println("Product = " + product);
    }

    private static void workingWithStreamsAndCOllector() {
        List<Student> students = List.of(
                new Student(1, "Tony", "tonny@example.com", "001"),
                new Student(2, "Harry", "harry@example.com", "002"),
                new Student(3, "Mackrine", "mackrine@example.com", "003"),
                new Student(4, "Martin", "martin@example.com", "004"),
                new Student(5, "Lena", "lena@example.com", "005"));

        List<StudentDto> studentDtos = students.stream()
                .filter(student -> student.getId() % 2 == 0)
                .map(student -> mapToStudentDto(student))
                .collect(Collectors.toList());

        System.out.println(studentDtos);
    }

    private static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(student.getFirstName(), student.getRegNo());
    }
}
