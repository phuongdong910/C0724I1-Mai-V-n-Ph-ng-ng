import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleClassifierTest {

    @Test
    public void testEquilateralTriangle() {
        assertEquals("tam giác đều", TriangleClassifier.classifyTriangle(2, 2, 2));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals("tam giác cân", TriangleClassifier.classifyTriangle(2, 2, 3));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals("tam giác thường", TriangleClassifier.classifyTriangle(3, 4, 5));
    }

    @Test
    public void testNotATriangle() {
        assertEquals("không phải là tam giác", TriangleClassifier.classifyTriangle(8, 2, 3));
    }

    @Test
    public void testNegativeSide() {
        assertEquals("không phải là tam giác", TriangleClassifier.classifyTriangle(-1, 2, 1));
    }

    @Test
    public void testZeroSide() {
        assertEquals("không phải là tam giác", TriangleClassifier.classifyTriangle(0, 1, 1));
    }
}