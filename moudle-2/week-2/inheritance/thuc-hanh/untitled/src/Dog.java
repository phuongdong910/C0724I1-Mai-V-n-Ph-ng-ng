public class Dog extends Animal{
    public Dog() {
        super("Dog");
    }

    @Override
    public void eat() {
        System.out.println("I am eating bone");    }

    @Override
    public void makeSound() {
        System.out.println("Gâu Gâu");    }

   
}
