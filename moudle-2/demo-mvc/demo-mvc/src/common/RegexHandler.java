package common;

public class RegexHandler {
    private static final String REGEX_POINT = "^([0-9])|10$";

    public static int checkRegexPoint() {
        int value = ExceptionHandler.checkParseInteger();
        while (!String.valueOf(value).matches(REGEX_POINT)) {
            System.out.print("Enter again: ");
            value = ExceptionHandler.checkParseInteger();
        }
        return value;
    }
}
