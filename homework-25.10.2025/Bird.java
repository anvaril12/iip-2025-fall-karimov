import org.w3c.dom.ls.LSOutput;

public class Bird extends Animal implements CanFly, CanRun, CanSwim {
    public Bird(String name, int age) {
        super(name,age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Чик-чирик");
    }

    @Override
    public void fly() {
        System.out.println(name + " ну очень быстро летает");
    }

    @Override
    public void run() {
        System.out.println(name + " не умеет бегать");
    }

    @Override
    public void swim() {
        System.out.println(name + "не умеет плавать, это же птица)");
    }
}
