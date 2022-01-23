public class Rectangle extends Shape {
    private Double height, width;

    public Rectangle(Double height, Double width) {
        setHeight(height);
        setWidth(width);
    }

    public final Double getHeight() {
        return height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public final Double getWidth() {
        return width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public void calculateArea() {
        setArea(height * width);
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(2 * height + 2 * width);
    }
}
