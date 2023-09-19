package com.systechafrica.part2.interfaces.employee;

public class EmployeeMain {

    public static void main(String[] args) {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        Employee employee = new Employee("Johh DOe", "Westlands, Nairobi", "johndoe@example.com");
        Employee newEmployee = employeeServiceImpl.createEmployee(employee);
        System.out.println(newEmployee);
    }
}
