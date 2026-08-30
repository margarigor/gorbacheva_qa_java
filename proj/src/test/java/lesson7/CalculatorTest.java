package lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testArithmeticOperations() {
        assertEquals(calculator.add(2, 3), 5);
        assertEquals(calculator.subtract(3, 2), 1);
        assertEquals(calculator.multiply(2, 3), 6);
        assertEquals(calculator.divide(5, 2), 2.5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZeroThrowsException() {
        calculator.divide(5, 0);
    }
}
