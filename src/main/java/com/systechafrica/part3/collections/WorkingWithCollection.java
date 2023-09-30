package com.systechafrica.part3.collections;

import java.util.ArrayList;
import java.util.Collection;

public class WorkingWithCollection {
    public static void main(String[] args) {
        Collection<Student> students = new ArrayList<>();
        Student student = new Student("John Doe","doe@gmail.com","0987");
        Student student2 = new Student("Smith","smith@gmail.com","068");
        students.add(student);
        students.add(student2);
        System.out.println(students);
    }
}
