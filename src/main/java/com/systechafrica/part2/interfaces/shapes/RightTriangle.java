package com.systechafrica.part2.interfaces.shapes;

public class RightTriangle implements Shape{
    double base;
    double height;
    double hypotenuse;

    public RightTriangle(double base, double height,double hypotenuse) {
        this.base = base;
        this.height = height;
        this. hypotenuse = hypotenuse;
    }


    @Override
    public double area() {
        return (0.5*base*height);
    }

    @Override
    public double perimeter() {
        return base + height + hypotenuse;
    }

    @Override
    public int verticesCount() {
        return 3;
    }
}
