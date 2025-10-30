public class Eagle extends Animal implements CanRun, CanSwim, CanFly {
    public Eagle(String name, int age) {
        super(name,age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: аррр-аррр");
    }

    @Override
    public void fly() {
        System.out.println(name + " летает очень быстро и хорошо");
    }

    @Override
    public void run() {
        System.out.println(name + " бегает медленно прыжками");
    }

    @Override
    public void swim() {
        System.out.println(name + "не умеет плавать");
    }
}
