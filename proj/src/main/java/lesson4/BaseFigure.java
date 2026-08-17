package lesson4;

public class BaseFigure implements FigureData {
    protected String fillColor;
    protected String borderColor;
    public String name;

    public BaseFigure(String borderColor, String fillColor) {
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }


    @Override
    public String getName() {
        return name;
    }
}
