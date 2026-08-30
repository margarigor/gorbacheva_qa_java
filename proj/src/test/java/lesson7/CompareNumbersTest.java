package lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompareNumbersTest {
    private final CompareNumbers compareNumbers = new CompareNumbers();

    @Test
    public void testCompare() {
        assertEquals(compareNumbers.compare(10, 5), 1);
        assertEquals(compareNumbers.compare(3, 7), -1);
        assertEquals(compareNumbers.compare(4, 4), 0);
    }
}
