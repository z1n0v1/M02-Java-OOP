public class Rectangle {
    private Point bottomLeft, topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return (point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX()) &&
                (point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY());
    }
}
