package common;

import java.util.Scanner;

public class ExceptionHandler {
    private static final Scanner sc = new Scanner(System.in);

    public static int checkParseInteger() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Sai định dạng, nhập lại:");
            }
        }
        return value;
    }
}
