public class Dog extends Animal implements CanRun,CanSwim, CanFly {
    public Dog(String name, int age) {
        super(name,age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " говорит: ГАВ");
    }

    @Override
    public void run() {
        System.out.println(name + " быстро бегает");
    }

    @Override
    public void fly() {
        System.out.println(name + " не умеет летать");
    }

    @Override
    public void swim() {
        System.out.println(name + " чуть-чуть умеет плавать");
    }
}