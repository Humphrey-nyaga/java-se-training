package com.systechafrica.part2;

public class ClassesDemo {
    public static void main(String[] args) {


        ClassesDemo app = new ClassesDemo();
        app.interns();
        app.carInstances();
    }
    public void carInstances(){
        Car forester = new Car();
        forester.color = "blue";
        forester.speed = 60;
        forester.startEngine();
        forester.accelerate(forester.speed);

        Car cx5 = new Car();
        cx5.color = "black";
        cx5.speed = 180;
        cx5.startEngine();
        cx5.accelerate(cx5.speed);

    }
    public void interns(){
        Intern hum = new Intern();
        hum.name = "Humphrey Nyaga";
        hum.email = "hum@example.com";
        hum.phoneNumber = "123456789";
        hum.doAssignment();
        hum.attendClass();

        Intern rojas = new Intern();
        rojas.name = "Rojas Smith";
        rojas.email = "smith@example.com";
        rojas.phoneNumber = "7878787890";
        rojas.doAssignment();
        rojas.attendClass();
    }
}
