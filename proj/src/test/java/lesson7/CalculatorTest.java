package lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testArithmeticOperations() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(2.5, calculator.divide(5, 2));
    }

    @Test
    void testDivisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
}
