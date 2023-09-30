package com.systechafrica.part3.collections;

import java.util.ArrayList;
import java.util.List;

/*
* List allows duplicate items.
* List is ordered
* List implements indexing for accessing and manipulating elements
* */
public class WorkingWithListAndArrayList {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        Student john = new Student("John Doe", "doe@gmail.com", "0987");
        Student student2 = new Student("Smith", "smith@gmail.com", "068");
        Student student3 = new Student("Johnson", "johnson@gmail.com", "069");
        Student student4 = new Student("Williams", "williams@gmail.com", "070");
        students.add(john);
        students.add(student2);
        students.add(student3);

        printStudents(students);
        students.set(2,student4);
        printStudents(students);
        System.out.println("students.remove(1) = " + students.remove(1));
        printStudents(students);
        System.out.println(students.indexOf(student4));
        System.out.println("students.size() = " + students.size());
        students.clear();
        printStudents(students);
        System.out.println("students.isEmpty() = " + students.isEmpty());



    }

    private static void printStudents(List<Student> students) {
        for (Student value : students) { //print list elements
            System.out.println(value);
        }
    }
}
