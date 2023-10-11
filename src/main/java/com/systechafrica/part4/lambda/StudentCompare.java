package com.systechafrica.part4.lambda;

import com.systechafrica.part4.functionalprogramming.Student;

@FunctionalInterface
public interface StudentCompare {
    boolean compare(Student s1, Student s2);
}
