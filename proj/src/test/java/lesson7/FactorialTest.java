package lesson7;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    private final Factorial factorial = new Factorial();

    @Test
    void testCalculate() {
        assertAll(
                () -> assertEquals(1, factorial.calculate(0)),
                () -> assertEquals(1, factorial.calculate(1)),
                () -> assertEquals(120, factorial.calculate(5))
        );
    }

    @Test
    void testNegativeNumberThrowsException() {
        // Проверяем, что при отрицательном числе выбрасывается ошибка
        assertThrows(IllegalArgumentException.class, () -> factorial.calculate(-5));
    }
}
