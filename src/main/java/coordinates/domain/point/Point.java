package coordinates.domain.point;

import coordinates.domain.point.unitcoordinate.UnitCoordinate;
import coordinates.domain.point.unitcoordinate.XCoordinate;
import coordinates.domain.point.unitcoordinate.YCoordinate;

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
        return xCoordinate.value();
    }

    public int getY() {
        return yCoordinate.value();
    }

    public XCoordinate getXCoordinate() {
        return xCoordinate;
    }

    public YCoordinate getYCoordinate() {
        return yCoordinate;
    }

    public boolean match(final int x, final int y) {
        return xCoordinate.match(x) && yCoordinate.match(y);
    }

    public double calculateDistanceTo(final Point point) {
        final UnitCoordinate differenceBetweenX = this.xCoordinate.calculatePositiveDifference(point.xCoordinate);
        final UnitCoordinate differenceBetweenY = this.yCoordinate.calculatePositiveDifference(point.yCoordinate);

        return Math.sqrt(differenceBetweenX.square() + differenceBetweenY.square());
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

    @Override
    public String toString() {
        return "Point{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}
