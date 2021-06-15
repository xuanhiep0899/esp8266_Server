package integrationTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class calculateTest{
    @Test
    public void sum() {
        int a = 3;
        int b = 5;
        assertEquals(a+b , 7);
    }
}
