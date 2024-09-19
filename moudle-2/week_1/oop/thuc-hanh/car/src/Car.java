import java.util.*;

public class Car {
    public String name;
    public Double price;
    public String brand;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" >> name: ");
        this.name = sc.nextLine();

        System.out.print(" >> price: ");
        this.price = sc.nextDouble();


    }

    public void output() {
        System.out.println("name: " + this.name);
        System.out.println("price: " + this.price);
    }
}
