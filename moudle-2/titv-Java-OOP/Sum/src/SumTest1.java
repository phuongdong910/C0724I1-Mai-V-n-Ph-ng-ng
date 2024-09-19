import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class SumTest1 { @Test
public void SumTest1(){
    int a  =1;
    int b = 1;
    int mongmuon = 2;
    int result = Sum.add(a,b);
    assertEquals(mongmuon,result);
}

}