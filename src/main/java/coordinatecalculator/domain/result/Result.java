package coordinatecalculator.domain.result;

import coordinatecalculator.domain.figure.Point;

import java.util.Collections;
import java.util.List;

public class Result {

    private final List<Point> points;

    private Result(final List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static Result of(final List<Point> points) {
        return new Result(points);
    }

    public boolean contains(final Point point) {
        return points.contains(point);
    }
}
