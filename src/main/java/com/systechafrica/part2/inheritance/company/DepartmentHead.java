package com.systechafrica.part2.inheritance.company;

public class DepartmentHead extends Employee{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DepartmentHead(String name, String empNo, String address, String title) {
        super(name, empNo, address);
        this.title = title;
    }
}
