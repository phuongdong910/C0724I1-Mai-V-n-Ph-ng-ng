import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    @Test
    public void testFizz() {
        assertEquals("Fizz", FizzBuzz.translate(3));
        assertEquals("Fizz", FizzBuzz.translate(9));
    }

    @Test
    public void testBuzz() {
        assertEquals("Buzz", FizzBuzz.translate(5));
        assertEquals("Buzz", FizzBuzz.translate(20));
    }

    @Test
    public void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.translate(15));
        assertEquals("FizzBuzz", FizzBuzz.translate(30));
    }

    @Test
    public void testNumber() {
        assertEquals("1", FizzBuzz.translate(1));
        assertEquals("7", FizzBuzz.translate(7));
    }
    @Test
    public void testContains3() {
        assertEquals("Fizz", FizzBuzz.translate(13));
        assertEquals("Fizz", FizzBuzz.translate(31));
    }

    @Test
    public void testContains5() {
        assertEquals("Buzz", FizzBuzz.translate(52));
        assertEquals("Buzz", FizzBuzz.translate(58));
    }

    @Test
    public void testNumberToWords() {
        assertEquals("một", FizzBuzz.translate(1));
        assertEquals("mười ba", FizzBuzz.translate(13)); // sẽ trả về "Fizz" trước khi kiểm tra từ
        assertEquals("hai mươi sáu", FizzBuzz.translate(26));
    }
}