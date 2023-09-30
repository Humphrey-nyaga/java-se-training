package com.systechafrica.part3.collections;

public class Student {
    private Integer id;
    private String name;
    private String email;
    private String regNo;

    public Student(String name, String email, String regNo) {
        this.name = name;
        this.email = email;
        this.regNo = regNo;
    }

    public Student(Integer id, String name, String email, String regNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.regNo = regNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", regNo='" + regNo + '\'' +
                '}';
    }
}
