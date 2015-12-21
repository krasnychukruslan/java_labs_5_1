import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class MainTest {

    @org.junit.Test
    public void testFindLessAverage() throws Exception {
        List<String> array = new ArrayList<String>();
        array.add("qwe");
        array.add("qwer");
        array.add("qwertyyyy");

        String[] expResult = new String[]{"qwe", "qwer"};
        List result = Lab1.findLessAverage(array);
        assertArrayEquals(expResult, result.toArray());
    }
    @org.junit.Test
    public void testFindLessAverage1() throws Exception {
        List<String> array = new ArrayList<String>();
        array.add("qwe");
        array.add("qwer");
        array.add("qwertyyyy");

        String[] expResult = new String[]{"qwer", "qwer"};
        List result = Lab1.findLessAverage(array);
        assertArrayEquals(expResult, result.toArray());
    }
}