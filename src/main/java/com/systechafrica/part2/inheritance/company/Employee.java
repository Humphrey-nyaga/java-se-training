package com.systechafrica.part2.inheritance.company;

public class Employee {
    private String name;
    private String empNo;
    private String address;

    public Employee(String name, String empNo, String address) {
        this.name = name;
        this.empNo = empNo;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Name: " + name + " No: " + empNo + " Address: " + address;
    }
}
