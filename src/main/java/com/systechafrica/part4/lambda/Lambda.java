package com.systechafrica.part4.lambda;

import com.systechafrica.part4.functionalprogramming.Student;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        // single line lambda function
        LambdaFunc func = () -> UUID.randomUUID().toString();
        // multi-line lambda function
        LambdaFunc func2 = () -> {
            return UUID.randomUUID().toString().substring(9);
        };
        // System.out.println("hey " + func.generateRandomUUID());
        // System.out.println("SubString UUID " + func2.generateRandomUUID());

        // Lambda func that doesnt return value and accepts multiple parameters
        GenerateReport<Student, Map<Integer, List<Integer>>> report = (student, scores) -> {
            System.out.println("*******************************");
            System.out.println("****SYSTECH STUDENT REPORT*****");
            System.out.println("*******************************");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getFirstName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Reg No: " + student.getRegNo());
            System.out.println("-----------Scores----------");
            printGrades(student.getId(), scores);
            System.out.println();
        };

        List<Student> students = List.of(
                new Student(1, "Joe Doe", "joedoe@example.com", "001"),
                new Student(2, "Smith Harry", "harrysmith@example.com", "002"),
                new Student(3, "Joy Smith", "joysmith@example.com", "003"),
                new Student(4, "Melvin Shawn", "melshawn@example.com", "004"),
                new Student(5, "John Mest", "johnmest@example.com", "005"));
        Map<Integer, List<Integer>> scores = new HashMap<>() {
            {
                put(1, List.of(85, 90, 78, 92, 87));
                put(2, List.of(78, 85, 90, 88, 92));
                put(3, List.of(92, 86, 79, 91, 84));
                put(4, List.of(89, 93, 80, 87, 91));
                put(5, List.of(84, 87, 92, 89, 78));
            }
        };

      // getSortedStudentAverageScores(scores);

        students.forEach(student -> report.generateReport(student, scores));

    }

    private static void getSortedStudentAverageScores(Map<Integer, List<Integer>> scores) {
        Map<Integer, Double> sortedMap = scores.entrySet()
                    .stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            entry -> entry.getValue().stream()
                                    .mapToDouble(Integer::doubleValue)
                                    .average()
                                    .orElse(0.0) 
                    ));

            // Sort the map by average grades
            sortedMap = sortedMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1, 
                            LinkedHashMap::new 
                    ));

            System.out.println("Sorted Map by Average Grades:");
            sortedMap.forEach((key, value) -> {
                System.out.println("Student ID: " + key);
                System.out.println("Average Grade: " + value);
            });
    }

    static void printGrades(int id, Map<Integer, List<Integer>> scores) {

        Optional<List<Integer>> studentScores = scores.entrySet()
                .stream()
                .filter(entry -> entry.getKey() == id)
                .map(Map.Entry::getValue)
                .findFirst();

        if (studentScores.isPresent()) {
            List<Integer> grades = studentScores.get();
            System.out.println(grades);
            double average = grades.stream()
                    .mapToDouble(Integer::doubleValue)
                    .average().getAsDouble();
            System.out.println("Average: " + average);
        } else {
            System.out.println("Student not found");
        }

      /*   scores.entrySet()
                .stream()
                .filter(entry -> entry.getKey() == id)
                .findFirst()
                .ifPresentOrElse(
                        entry -> {
                            System.out.println(entry.getValue());
                        },
                        () -> {
                            System.out.println("Student with ID " + id + " not found.");
                        }); */
    }
}
