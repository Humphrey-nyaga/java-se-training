package com.systechafrica.part2.casting;

import com.systechafrica.part2.inheritance.animals.Animal;
import com.systechafrica.part2.inheritance.animals.Cat;
import com.systechafrica.part2.inheritance.animals.Dog;

public class CastingDemo {
    public static void main(String[] args) {
        CastingDemo app = new CastingDemo();
        Animal animal = new Dog(); //upcasting - implicit casting
        Animal animal2 = new Cat();
        app.printInfo(animal);
        app.printInfo(animal2);

    }
    public void printInfo(Animal animal){
        if(animal instanceof Dog dog){
            dog.makeSound();
        } else if (animal instanceof Cat cat) {
            cat.makeSound();

        }

    }
}
