package com.systechafrica.part3.inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WorkingWithObjectStream {
    public static void main(String[] args) {
        // String fileSeparator = System.getProperty("file.separator");
        File studentFile = new File("students.txt");

        Student s1 = new Student("123", "John", "Doe");
        Student s2 = new Student("234", "Mary", "Smith");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(studentFile))) {
            objectOutputStream.writeObject(s1);
            objectOutputStream.writeObject(s2);
        } catch (Exception e) {
            System.err.println("Exception Writing Object : " + e);
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(studentFile))) {
            Student student;
            while(((student = (Student)objectInputStream.readObject()) != null){
                System.out.println(objectInputStream.readObject());
            }
        } catch (Exception e) {
            System.err.println("Exception Reading Object : " + e);

        }
    }
}
