import org.w3c.dom.ls.LSOutput;

public class Monkey extends Animal implements CanRun, CanFly, CanSwim {
    public Monkey(String name, int age) {
        super(name,age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: АУААА");
    }

    @Override
    public void run() {
        System.out.println(name + " бегает не так быстро");
    }

    @Override
    public void fly() {
        System.out.println(name + "не умеет летать, тимур же туповатый");
    }

    @Override
    public void swim() {
        System.out.println(name + "мб умеет плавать, но ни разу не видел плавабщих обезьян");
    }
}
