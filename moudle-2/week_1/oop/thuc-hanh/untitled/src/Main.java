import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width: ");
        double width = sc.nextDouble();
        System.out.print("Enter the height: ");
        double height = sc.nextDouble();

        Rectangle rectangle1 = new Rectangle(width, height);
        System.out.println("Your rectangle is: " + rectangle1.display());
        System.out.println("Area of the rectangle: " + rectangle1.getArea());
        System.out.println("Premeter of the rectangle: " + rectangle1.getPerimeter());
    }
}