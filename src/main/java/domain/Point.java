package domain;

import domain.coordinate.XCoordinate;
import domain.coordinate.YCoordinate;

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
        return x.getValue() - another.x.getValue();
    }

    public int subY(Point another) {
        return y.getValue() - another.y.getValue();
    }
}
