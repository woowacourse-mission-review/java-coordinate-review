package domain;

import domain.exception.InvalidNumberOfPointsException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeFactory {
    public static final int LINE_NUMBER_OF_POINTS = 2;
    public static final int TRIANGLE_NUMBER_OF_POINTS = 3;
    public static final int RECTANGLE_NUMBER_OF_POINTS = 4;

    private static final Map<Integer, Function<List<Point>, Shape>> creator
            = new HashMap<Integer, Function<List<Point>, Shape>>() {
        {
            put(LINE_NUMBER_OF_POINTS, Line::new);
            put(TRIANGLE_NUMBER_OF_POINTS, Triangle::new);
            put(RECTANGLE_NUMBER_OF_POINTS, Rectangle::new);
        }
    };

    public static Shape create(List<Point> points) {
        try {
            return creator.get(points.size()).apply(points);
        } catch (NullPointerException e) {
            throw new InvalidNumberOfPointsException();
        }
    }
}
