package coordinates.domain.figure;

import coordinates.domain.point.Point;
import coordinates.domain.point.Points;
import coordinates.exception.IllegalFigureCreationException;

public class Line implements Figure {

    public static final int SIZE_OF_POINTS_IN_LINE = 2;

    private final Points points;

    private Line(final Points points) {
        if (points.size() != SIZE_OF_POINTS_IN_LINE) {
            throw new IllegalFigureCreationException();
        }

        this.points = points;
    }

    public static Line from(Points points) {
        return new Line(points);
    }

    @Override
    public int size() {
        return SIZE_OF_POINTS_IN_LINE;
    }

    @Override
    public double area() {
        Point point1 = points.get(0);
        Point point2 = points.get(1);

        return point1.calculateDistanceTo(point2);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
