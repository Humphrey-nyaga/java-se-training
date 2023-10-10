package com.systechafrica.part4.functionalprogramming.filteringproblems;

import java.util.Arrays;
import java.util.List;

public class EmployeeMainDemo {

    static List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR"),
            new Employee("Bob", 25, "IT"),
            new Employee("Charlie", 35, "Finance"),
            new Employee("David", 28, "IT"),
            new Employee("Eve", 32, "Finance"),
            new Employee("Frank", 28, "HR"));

    /*
     * Filter and print the names of employees who are younger than 30.
     */
    static void employeeAgesLessThan30() {
        System.out.println("Employees with Age less than 30");
        employees.stream()
                .filter(employee -> employee.getAge() < 30)
                .forEach(employee -> System.out.println("Name: " + employee.getName()));
    }

    /*
     * Filter and print the names of employees in the IT department.
     */
    static void employeesInDepartment() {
        System.out.println("Employees in IT Department");
        employees.stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .forEach(employee -> System.out.println(employee.getName()));
    }

    /*
     * Filter and print the names of employees in the Finance department who are
     * older than 30.
     */
    static void employeesInFinanceAgeGreaterThan30() {
        System.out.println("Employees In Finance Age Geater Than 30");
        employees.stream()
                .filter(employee -> employee.getDepartment().equals("Finance"))
                .filter(employee -> employee.getAge() > 30)
                .forEach(employee -> System.out.println(employee.getName()));
    }

    /*
     * Find and print the average age of all employees.
     */
    static void employeeAverageAge() {

        double ageAverage = employees.stream()
                .mapToDouble(employee -> employee.getAge())
                .average().getAsDouble();
        System.out.println("Employees Average Age: " + ageAverage);
    }

    /* Find and print the maximum age among employees. */

    static void maxAge() {

        int maxAge = employees.stream()
                .mapToInt(employee -> employee.getAge())
                .max().getAsInt();
        System.out.println("Employees Highest Age: " + maxAge);
    }

    /*
     * Filter and print the names of employees whose names start with the letter
     * 'A'.
     */
    static void nameStartsWithM() {
        System.out.println("Employees Name Starts With A");
        employees.stream()
                .filter(employee -> employee.getName().startsWith("A"))
                .forEach(employee -> System.out.println(employee.getName()));
    }

    public static void main(String[] args) {
        employeeAgesLessThan30();
        employeesInDepartment();
        employeesInFinanceAgeGreaterThan30();
        employeeAverageAge();
        maxAge();
        nameStartsWithM();
    }
}
