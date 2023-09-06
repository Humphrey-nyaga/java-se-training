package com.systechafrica.part2.accessmodifiers;

public class Employee {
    String name;
    boolean contract;
    double salary;

    public Employee() {
        this.name  = "Joe";
        this.contract = true;
        this.salary = 100.0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", contract=" + contract +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        System.out.println(e);
    }
}
