package com.systechafrica.part2.interfaces.employee;

import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(UUID.randomUUID());
        return employee;
    }
}
