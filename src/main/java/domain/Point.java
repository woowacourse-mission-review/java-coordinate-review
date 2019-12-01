package domain;

import domain.coordinate.XCoordinate;
import domain.coordinate.YCoordinate;

import java.util.Objects;

public class Point {
    private final XCoordinate x;
    private final YCoordinate y;

    private Point(XCoordinate x, YCoordinate y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(XCoordinate x, YCoordinate y) {
        return new Point(x, y);
    }

    public int getX() {
        return x.getValue();
    }

    public int getY() {
        return y.getValue();
    }

    public int subX(Point another) {
        return x.sub(another.x);
    }

    public int subY(Point another) {
        return y.sub(another.y);
    }

    public double distance(Point another) {
        // Pythagorean theorem
        return Math.sqrt(Math.pow(x.sub(another.x), 2.0) + Math.pow(y.sub(another.y), 2.0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
