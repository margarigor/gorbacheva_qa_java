package lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleAreaTest {
    private final TriangleArea triangleArea = new TriangleArea();

    @Test
    public void testCalculateArea() {
        assertEquals(triangleArea.calculateArea(4, 5), 10.0);
        assertEquals(triangleArea.calculateArea(0, 5), 0.0);
    }
}
