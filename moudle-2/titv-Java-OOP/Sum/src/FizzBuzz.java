public class FizzBuzz {
    public static String translate(int number) {
        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;
        boolean contains3 = String.valueOf(number).contains("3");
        boolean contains5 = String.valueOf(number).contains("5");

        if (divisibleBy3 && divisibleBy5) {
            return "FizzBuzz";
        } else if (divisibleBy3 || contains3) {
            return "Fizz";
        } else if (divisibleBy5 || contains5) {
            return "Buzz";
        } else {
            return numberToWords(number);
        }
    }

    private static String numberToWords(int number) {
        String[] units = { "", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };
        if (number < 10) {
            return units[number];
        } else if (number < 20) {
            return "mười " + units[number % 10];
        } else {
            return units[number / 10] + " mươi " + units[number % 10];
        }
    }

}