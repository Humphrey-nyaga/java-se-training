package com.systechafrica.part2.classes;

public class Car {
    String color;
    int speed;

    void startEngine(){
        System.out.println("Engine started!");
    }
    void accelerate(int speed){
        speed += 10;
        System.out.println("Speed increased to: " + speed);
    }
}
