package com.systechafrica.part2.classes;

public class ClassesDemo {
    public static void main(String[] args) {
        ClassesDemo app = new ClassesDemo();
         // app.calculatorInstance();
        app.interns();
//        app.carInstances();

    }

    public void carInstances() {
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

    public void interns() {
        Intern hum = new Intern("Humphrey Nyaga","hum@example.com","123456789");
        hum.doAssignment();
        hum.attendClass();
        System.out.println(hum.name);
        System.out.println(hum.email);

        Intern rojas = new Intern("Rojas Smith","smith@example.com","7878787890");
        rojas.doAssignment();
        rojas.attendClass();
        System.out.println(rojas.name);
        System.out.println(rojas.email);
    }
    public void calculatorInstance(){
        Calculator calculator = new Calculator();
        calculator.displayWelcomeMessage();
        System.out.println("Sum is: " + calculator.add(6, 8));
    }
}
