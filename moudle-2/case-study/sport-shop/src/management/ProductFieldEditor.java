package management;

import java.util.Scanner;

public class ProductFieldEditor {
    protected static String editStringField(String fieldName, String currentValue, Scanner input) {
        System.out.print("Enter new" + fieldName + "( or press Enter to skip)");
        String newValue = input.nextLine().trim();
        if (!newValue.isEmpty() && !newValue.equals(currentValue)) {
            System.out.println(fieldName + " update successfully.");
            return newValue;
        }
        return currentValue;
    }

    protected static int editIntegerField(String fieldName, int currentValue, Scanner input) {
        System.out.print("Enter new" + fieldName + "( or press Enter to skip)");
        String newValue = input.nextLine().trim();
        if (!newValue.isEmpty()) {
            try {
                int intValue = Integer.parseInt(newValue);
                if (intValue != currentValue) {
                    System.out.println(fieldName + " update successfully.");
                    return intValue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number");
            }
        }
        return currentValue;
    }

    protected static double editDoubleField(String fieldName, double currentValue, Scanner input) {
        System.out.print("Enter new" + fieldName + "( or press Enter to skip)");
        String newValue = input.nextLine().trim();
        if (!newValue.isEmpty()) {
            try {
                double doubleValue = Double.parseDouble(newValue);
                if (doubleValue != currentValue) {
                    System.out.println(fieldName + " update successfully.");
                    return doubleValue;
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number");
            }
        }
        return currentValue;

    }
}
