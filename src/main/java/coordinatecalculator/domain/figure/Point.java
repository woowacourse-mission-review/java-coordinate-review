package coordinatecalculator.domain.figure;

import coordinatecalculator.domain.coordinates.XCoordinate;
import coordinatecalculator.domain.coordinates.YCoordinate;

import java.util.Objects;

public class Point {

    private final XCoordinate xCoordinate;
    private final YCoordinate yCoordinate;

    private Point(final XCoordinate xCoordinate, final YCoordinate yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static Point of(final int xCoordinate, final int yCoordinate) {
        return new Point(XCoordinate.of(xCoordinate), YCoordinate.of(yCoordinate));
    }

    public int xValue() {
        return xCoordinate.value();
    }

    public int yValue() {
        return yCoordinate.value();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return xCoordinate.equals(point.xCoordinate) &&
                yCoordinate.equals(point.yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
