import org.w3c.dom.ls.LSOutput;

public class Dolphin extends Animal implements CanRun, CanSwim, CanFly {
    public Dolphin(String name, int age) {
        super(name,age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Клик-клик");
    }

    @Override
    public void fly() {
        System.out.println(name + " не умеет летать");
    }

    @Override
    public void run() {
        System.out.println(name + " ни разу не видел бегающих дельфинов");
    }

    @Override
    public void swim() {
        System.out.println(name + " плавает лучше всех");
    }
}
