package com.systechafrica.part4.lambda;

import com.systechafrica.part4.functionalprogramming.Student;

public class StudentCompareDemo {
    public static void main(String[] args) {

        // lambda implmentation for functional interface methods
        StudentCompare studentCompare = (student1, student2) -> {
            return student1.equals(student2);
        };

        StudentCompare studentCompare2 = (student1, student2) -> {
            return student1.getFirstName().equals(student2.getFirstName());
        };
        StudentCompare studentCompare3 = (student1, student2) -> {
            return student1.getId() == student2.getId();
        };

        Student s1 = new Student(1, "Joe Doe", "joedoe@example.com", "001");
        Student s2 = new Student(2, "Smith Harry", "harrysmith@example.com", "002");
        Student s3 = s1;
        Student s4 = new Student(1, "Smith Harry", "smithh@example.com", "003");

        System.out.println("Student s1 equals student s3: " + studentCompare.compare(s1, s3));
        System.out.println("Student s2 name equals student s3 name: " + studentCompare2.compare(s2, s3));
        System.out.println("Student s1 ID equals student s4 ID: " + studentCompare3.compare(s1, s4));

    }

}
