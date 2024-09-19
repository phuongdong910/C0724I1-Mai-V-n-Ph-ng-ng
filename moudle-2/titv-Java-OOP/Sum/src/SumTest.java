import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {
    @Test
    public void SumTest1(){
        int a  =1;
        int b = 3;
        int mongmuon = 2;
        int result = Sum.add(a,b);
        assertEquals(mongmuon,result);
    }
}
