package lesson7;

public class TriangleArea {

    public double calculateArea(double base, double height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Размеры не могут быть отрицательными");
        }
        return 0.5 * base * height;
    }
}
