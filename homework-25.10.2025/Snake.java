public class Snake extends Animal implements CanRun, CanSwim, CanFly {
    public Snake(String name,int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: тссс-тссс");
    }

    @Override
    public void fly() {
        System.out.println(name + " не умеет летать");
    }

    @Override
    public void run() {
        System.out.println(name + " не умеет бегать, она ползает");
    }

    @Override
    public void swim() {
        System.out.println(name + " не умеет плавать, она же змея");
    }
}
