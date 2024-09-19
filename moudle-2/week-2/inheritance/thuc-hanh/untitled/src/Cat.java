public class Cat extends Animal{
    public Cat() {
        super("Cat");
    }

    @Override
    public void eat() {
        System.out.println("I am eating fish");    }

    @Override
    public void makeSound() {
        System.out.println("meo meo");    }
}
