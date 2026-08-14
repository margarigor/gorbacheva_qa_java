package lesson4;

public interface FigureData {
    double getArea();
    String getFillColor();
    String getBorderColor();
    double getPerimeter();
    String getName();

    default double getSum(double... sides) {
        double perimeter = 0;
        for (double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }
    default void printInfo() {
        System.out.println(getName());
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Цвет фона (заливки): " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
        System.out.println();
    }
}
