package exercise;

// BEGIN
public class Circle {
    private final Point circleCenter;
    private final int radius;

    public Circle(Point circleCenter, int radius) {
        this.circleCenter = circleCenter;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return Math.PI * radius * radius;
    }
}
// END
