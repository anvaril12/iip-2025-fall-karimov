package animals;

import interfaces.CanFly;
import interfaces.CanRun;
import interfaces.CanSwim;

public class Cat extends Animal implements CanRun, CanFly, CanSwim {
    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " говорит: МЯУ");
    }

    @Override
    public void run() {
        System.out.println(name + " очень быстро бегает");
    }

    @Override
    public void fly() {
        System.out.println(name + " не умеет летать");
    }

    @Override
    public void swim() {
        System.out.println(name + "не умеет плавать, коты боятся воды");
    }
}
