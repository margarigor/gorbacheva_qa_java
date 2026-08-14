package lesson4;

public class Triangle extends BaseFigure {

    private double a;
    private double b;
    private double c;

    public Triangle(String borderColor, String fillColor, double a, double b, double c) {
        super(borderColor, fillColor);
        super.name = "Triangle";
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getPerimeter() {
        return getSum(a,b,c);
    }
}

