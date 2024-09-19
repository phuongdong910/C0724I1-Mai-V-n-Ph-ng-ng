import java.util.Scanner;

public class NumberToWords {

    // Phương thức chính để đọc số
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (0 - 999): ");
        int number = scanner.nextInt();

        if (number < 0 || number > 999) {
            System.out.println("Out of ability");
        } else {
            System.out.println(readNumber(number));
        }
    }

    // Phương thức đọc số
    public static String readNumber(int number) {
        if (number < 10) {
            return readSingleDigit(number);
        } else if (number < 20) {
            return readTeens(number);
        } else if (number < 100) {
            return readTens(number);
        } else {
            int hundreds = number / 100;
            int remainder = number % 100;
            if (remainder == 0) {
                return readSingleDigit(hundreds) + " hundred";
            } else {
                return readSingleDigit(hundreds) + " hundred and " + readNumber(remainder);
            }
        }
    }

    // Đọc các số từ 0 đến 9
    public static String readSingleDigit(int number) {
        switch (number) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }

    // Đọc các số từ 10 đến 19
    public static String readTeens(int number) {
        switch (number) {
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default: return "";
        }
    }

    // Đọc các số từ 20 đến 99
    public static String readTens(int number) {
        int tens = number / 10;
        int ones = number % 10;
        String result = "";
        switch (tens) {
            case 2: result = "twenty"; break;
            case 3: result = "thirty"; break;
            case 4: result = "forty"; break;
            case 5: result = "fifty"; break;
            case 6: result = "sixty"; break;
            case 7: result = "seventy"; break;
            case 8: result = "eighty"; break;
            case 9: result = "ninety"; break;
        }

        if (ones != 0) {
            result += " " + readSingleDigit(ones);
        }
        return result;
    }
}