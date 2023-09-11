package com.systechafrica.part2.inheritance.company;

public class SoftwareEngineer extends Employee{
    private String title;

    public SoftwareEngineer(String name, String empNo, String address, String title) {
        super(name, empNo, address);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "Name: " + getName() + " No: " + getEmpNo() + " Address: " + getAddress() + " Title: " + getTitle();
    }
}
