import java.util.Scanner;

public class BankInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số tiền gửi n");
        double money = scanner.nextDouble();

        System.out.println("Nhập số năm gửi m");
        int years = scanner.nextInt();

        final double interestRate = 0.06;

        double amount = money;

        for (int i = 0; i < years; i++) {
            amount += amount * interestRate;
        }

        System.out.printf("Tổng số tiền sau %d năm gửi là: %.2f", years, amount);
    }
}