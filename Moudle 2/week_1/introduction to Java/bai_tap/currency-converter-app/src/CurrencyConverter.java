import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        double rate = 25000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount USD");
        double USD = scanner.nextDouble();
        double VND = USD * rate;
        System.out.printf("%.2f USD = %.0fVND", USD, VND);
        scanner.close();


    }
}
