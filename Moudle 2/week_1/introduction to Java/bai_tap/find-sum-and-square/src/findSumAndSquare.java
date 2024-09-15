import java.util.Scanner;

public class findSumAndSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên b (a < b): ");
        int b = scanner.nextInt();

        if (a >= b) {
            System.out.println("a phải nhỏ hơn b.");
            return;
        }

        int sum = 0;
        for( int i = a; i <=b; i++){
            sum += i;
        }
        System.out.println("Tổng các số  từ " + a + "tới" +b+ "là: " +sum);

        // In ra các số chính phương

        System.out.print("Các số chính phương từ " + a + " tới " + b + " là: ");
        for (int i = a; i <= b; i++) {
            if (isPerfectSquare(i)) {
                System.out.print(i + " ");
            }
    }
}
    public static boolean isPerfectSquare(int number) {
        if (number < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        return (sqrt * sqrt == number);
    }
}
