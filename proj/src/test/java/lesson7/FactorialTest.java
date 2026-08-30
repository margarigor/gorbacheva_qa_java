package lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {
    private final Factorial factorial = new Factorial();

    @Test
    public void testCalculate() {
        // В TestNG: сначала фактическое значение, потом ожидаемое
        assertEquals(factorial.calculate(0), 1);
        assertEquals(factorial.calculate(1), 1);
        assertEquals(factorial.calculate(5), 120);
    }

    // Проверка исключения через параметр аннотации @Test
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumberThrowsException() {
        factorial.calculate(-5);
    }
}
