package com.systechafrica.part2.interfaces.shapes;

public interface Shape {
    double PI = 3.14;
    double area();
    double perimeter();
    default int verticesCount(){
        return 0;
    };

}
