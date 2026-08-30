package lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareNumbersTest {
    private final CompareNumbers compareNumbers = new CompareNumbers();

    @Test
    void testCompare() {
        assertEquals(1, compareNumbers.compare(10, 5));
        assertEquals(-1, compareNumbers.compare(3, 7));
        assertEquals(0, compareNumbers.compare(4, 4));
    }
}
