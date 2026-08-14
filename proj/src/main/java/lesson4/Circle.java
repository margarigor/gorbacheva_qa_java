package lesson4;

public class Circle extends BaseFigure {
    private double rad;


    public Circle(String borderColor, String fillColor, double rad) {
        super(borderColor, fillColor);
        super.name = "Circle";
        this.rad = rad;
    }

    @Override
    public double getArea() {
        return Math.PI * rad * rad;
    }

    @Override
    public String getBorderColor() {
        return super.getBorderColor();
    }

    @Override
    public String getFillColor() {
        return super.getFillColor();
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.rad;
    }
}
