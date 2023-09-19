package com.systechafrica.part2.interfaces.shapes;

public class ShapesMain {
    public static void main(String[] args) {
        Circle ci = new Circle(14);
        System.out.println("Circle area: " + ci.area());
        System.out.println("Circle perimeter: " + ci.perimeter());

        RightTriangle triangle = new RightTriangle(16, 12, 20);
        System.out.println("Triangle area: " + triangle.area());
        System.out.println("Triangle perimeter: " + triangle.perimeter());
        System.out.println("Vertices Count: "+ triangle.verticesCount());
    }
}
