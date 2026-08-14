package lesson4;

public class Square extends BaseFigure {

    private double side;

    public Square(String borderColor, String fillColor, double side) {
        super(borderColor, fillColor);
        super.name = "Square";
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
    @Override
    public double getPerimeter() {
        return getSum(side, side, side, side);
    }
}
