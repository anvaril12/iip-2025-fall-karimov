package animals;

import interfaces.CanFly;
import interfaces.CanRun;
import interfaces.CanSwim;

public class Turtle extends Animal implements CanRun, CanSwim, CanFly {
    public Turtle(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: ничего");
    }

    @Override
    public void fly() {
        System.out.println(name + " не умеет летать");
    }

    @Override
    public void run() {
        System.out.println(name + " очень медленно ползет");
    }

    @Override
    public void swim() {
        System.out.println(name + " хорошо плавает");
    }
}
