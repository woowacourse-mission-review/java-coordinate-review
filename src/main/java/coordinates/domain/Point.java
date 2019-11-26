package coordinates.domain;

import java.util.Objects;

public class Point {

    private final XCoordinate xCoordinate;
    private final YCoordinate yCoordinate;

    private Point(final int x, final int y) {
        this.xCoordinate = XCoordinate.from(x);
        this.yCoordinate = YCoordinate.from(y);
    }

    public static Point of(final int x, final int y) {
        return new Point(x, y);
    }

    public int getX() {
        return xCoordinate.getX();
    }

    public int getY() {
        return yCoordinate.getY();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return Objects.equals(xCoordinate, point.xCoordinate) &&
                Objects.equals(yCoordinate, point.yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
