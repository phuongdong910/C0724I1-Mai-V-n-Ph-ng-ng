import java.util.Scanner;

public class ShapesDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle(bottom-left)");
        System.out.println("3. Print the square triangle(top-left)");
        System.out.println("4. Print isosceles");
        System.out.println("5. Exit");
        System.out.println("Choose an option(1-5: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                printRectangle();
                break;
            case 2:
                printBottomLeftTriangle();
                break;
            case 3:
                printTopLeftTriangle();
                break;
            case 4:
                printIsoscelesTriangle();
                break;
            case 5:
                System.out.println("Exiting....");
                return;
            default:
                System.out.println("Invalid choice. Please chose between 1 to 5");

        }
    }

    private static void printRectangle() {
        int width = 7;
        int height = 3;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printBottomLeftTriangle() {
        int size = 5;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    private static void printTopLeftTriangle() {
        int size = 5;
        for (int i = size; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    private static void printIsoscelesTriangle() {
        int height = 5;
        for (int i = 1; i <= height; i++) {
            // In khoảng trắng trước dấu *
            for (int j = i; j < height; j++) {
                System.out.print("  ");
            }
            // In dấu *
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}