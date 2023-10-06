package com.systechafrica.part4.functionalprogramming;

public class Student {
    private int id;
    private String firstName;
    private String email;
    private String regNo;

    public Student(int id, String firstName, String email, String regNo) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.regNo = regNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (regNo == null) {
            if (other.regNo != null)
                return false;
        } else if (!regNo.equals(other.regNo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", email=" + email + ", regNo=" + regNo + "]";
    }

}
