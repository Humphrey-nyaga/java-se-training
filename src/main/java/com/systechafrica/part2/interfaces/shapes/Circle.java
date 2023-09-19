package com.systechafrica.part2.interfaces.shapes;

public class Circle implements Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * radius *radius;
    }

    @Override
    public double perimeter() {
        return PI *(radius*2);
    }

}
