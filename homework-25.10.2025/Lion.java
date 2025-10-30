public class Lion extends Animal implements CanRun, CanSwim, CanFly {
    public Lion(String name, int age) {
        super(name,age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: МЯУ только громко");
    }

    @Override
    public void fly() {
        System.out.println(name + " не умеет летать");
    }

    @Override
    public void run() {
        System.out.println(name + " очень быстро бегает");
    }

    @Override
    public void swim() {
        System.out.println(name + "неплохо плавает");
    }
}
