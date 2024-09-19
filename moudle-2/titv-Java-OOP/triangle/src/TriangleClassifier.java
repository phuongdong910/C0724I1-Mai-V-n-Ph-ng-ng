import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleClassifier {
    public static String classifyTriangle(int a, int b, int c) {
        // Kiểm tra điều kiện không phải tam giác
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return "không phải là tam giác";
        }
        // Kiểm tra tam giác đều
        if (a == b && b == c) {
            return "tam giác đều";
        }
        // Kiểm tra tam giác cân
        if (a == b || b == c || a == c) {
            return "tam giác cân";
        }
        // Tam giác thường
        return "tam giác thường";
    }
}