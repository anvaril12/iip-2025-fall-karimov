import animals.*;
import interfaces.CanFly;
import interfaces.CanRun;
import interfaces.CanSwim;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Бобик", 4),
                new Cat("Мурзик", 5),
                new Bird("Чирик", 1),
                new Monkey("Тимур", 18),
                new Lion("Симба", 5),
                new Dolphin("Флиппер", 7),
                new Penguin("Пинги", 2),
                new Snake("Каа", 10),
                new Turtle("Донни", 50),
                new Eagle("Паша" , 6)
        };
        for (Animal animal : animals) {
            System.out.println(animal.getString());
            animal.makeSound();
            animal.sleep();

            ((CanFly) animal).fly();
            ((CanRun) animal).run();
            ((CanSwim) animal).swim();

            System.out.println(); // Пустая строка для красоты
        }
    }
}