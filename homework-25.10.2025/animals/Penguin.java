package animals;

import interfaces.CanFly;
import interfaces.CanRun;
import interfaces.CanSwim;

public class Penguin extends Animal implements CanRun, CanFly, CanSwim {
    public Penguin(String name, int age) {
        super(name,age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: фр-фр-фр");
    }

    @Override
    public void fly() {
        System.out.println(name + " пингвины не летают");
    }

    @Override
    public void run() {
        System.out.println(name + " слабенько бегают");
    }

    @Override
    public void swim() {
        System.out.println(name + " очень быстро плавают");
    }
}
