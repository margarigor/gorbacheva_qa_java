package lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleAreaTest {
    private final TriangleArea triangleArea = new TriangleArea();

    @Test
    void testCalculateArea() {
        assertEquals(10.0, triangleArea.calculateArea(4, 5));
        assertEquals(0.0, triangleArea.calculateArea(0, 5));
    }
}
