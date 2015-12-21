package kpi.com.ua;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindPrimeNum() throws Exception {
        assertEquals(79, Main.findPrimeNum(100));
        assertEquals(7, Main.findPrimeNum(10));
        assertEquals(479, Main.findPrimeNum(500));
    }
    @Test
    public void testFindPrimeNum1() throws Exception {
        assertEquals(74, Main.findPrimeNum(100));
    }
}