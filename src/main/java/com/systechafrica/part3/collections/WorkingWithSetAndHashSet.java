package com.systechafrica.part3.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* Set has unordered elements
* Allows only unique elements that is, no duplicates
* Provides fast look up compared to lists
* Does not provide indexing
* */
public class WorkingWithSetAndHashSet {

    public static void duplicatedListToSet(){
        List<String> europeCountries = List.of("Germany","Italy","Switzerland","Poland","Netherlands","Poland","Germany","Monaco");

        List<String> africaCountries = List.of("Kenya","South Africa","Morocco","Mauritius","Ghana","Morocco","Nigeria","Uganda","Egypt");

        Set<String> countries = new HashSet<>(europeCountries);
        countries.addAll(africaCountries);
        System.out.println("\n------------------Countries------------------");
        System.out.println(countries);

    }
    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<>();
        Student doe = new Student("John Doe", "doe@gmail.com", "0987");
        Student smith = new Student("Smith", "smith@gmail.com", "068");
        Student harry = new Student("Johnson Harry", "johnson@gmail.com", "069");
        Student williams = new Student("Williams", "williams@gmail.com", "070");
        studentSet.add(doe);
        studentSet.add(smith);
        studentSet.add(williams);

        System.out.println("studentSet.size() = " + studentSet.size());
        printStudentInfo(studentSet);

        studentSet.add(harry);
        System.out.println("\n------After Adding New Student---");
        printStudentInfo(studentSet);

        // Try adding a duplicate element
        studentSet.add(doe);

        System.out.println("\n------After Adding Duplicate Student---");
        printStudentInfo(studentSet);

        System.out.println("\n------After Removing Student---");
        studentSet.remove(williams);
        printStudentInfo(studentSet);

        System.out.println("\n------Check if object is available in set---");
        System.out.println("studentSet.contains(smith) = " + studentSet.contains(smith));
        duplicatedListToSet();

    }

    private static void printStudentInfo(Set<Student> studentSet) {
        for (Student s: studentSet) {
            System.out.println(s);
        }
    }
}
