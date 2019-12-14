package coordinate.domain.point;

import java.util.Objects;

public class Point {
    private final Coordinate x;
    private final Coordinate y;

    private Point(final int x, final int y) {
        this.x = Coordinate.of(x);
        this.y = Coordinate.of(y);
    }

    public static Point of(final int x, final int y) {
        return new Point(x, y);
    }

    public double distanceTo(final Point other) {
        double squareOfX = square(this.x.value(), other.x.value());
        double squareOfY = square(this.y.value(), other.y.value());
        return Math.sqrt(squareOfX + squareOfY);
    }

    private double square(final int first, final int second) {
        return Math.pow(first - second, 2);
    }

    public double distanceXTo(final Point other) {
        return distanceAbs(this.getX(), other.getX());
    }

    public double distanceYTo(final Point other) {
        return distanceAbs(this.getY(), other.getY());
    }

    private int distanceAbs(final int x1, final int x2) {
        return Math.abs(x1 - x2);
    }

    public int getX() {
        return x.value();
    }

    public int getY() {
        return y.value();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }
}
