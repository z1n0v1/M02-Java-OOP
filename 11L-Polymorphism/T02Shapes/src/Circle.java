public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public final double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(2 * Math.PI * radius);
    }

    @Override
    public void calculateArea() {
        setArea(Math.PI * radius * radius);
    }
}
