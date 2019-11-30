package coordinates.domain.point;

import coordinates.exception.DuplicatePointsException;
import coordinates.exception.NotRectangleException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Points {

    private static final int KINDS_OF_COORDINATES_IN_RECTANGLE = 2;
    private static final int SIZE_OF_POINTS_IN_SQUARE = 4;

    private final List<Point> innerPoints;

    private Points(final List<Point> innerPoints) {
        validatePoints(innerPoints);

        this.innerPoints = innerPoints;
    }

    private void validatePoints(final List<Point> innerPoints) {
        if (hasDuplicatePoints(innerPoints)) {
            throw new DuplicatePointsException();
        }

        if (isSquare(innerPoints) && isNotRectangle(innerPoints)) {
            throw new NotRectangleException();
        }
    }

    private boolean isSquare(final List<Point> innerPoints) {
        return innerPoints.size() == SIZE_OF_POINTS_IN_SQUARE;
    }

    private boolean isNotRectangle(final List<Point> pointList) {
        return checkKindsOfCoordinate(pointList, Point::getX) || checkKindsOfCoordinate(pointList, Point::getY);
    }

    private boolean checkKindsOfCoordinate(final List<Point> pointList, final ToIntFunction<Point> function) {
        Set<Integer> numberSet = pointList.stream()
                .mapToInt(function)
                .boxed()
                .collect(Collectors.toSet());

        return numberSet.size() != KINDS_OF_COORDINATES_IN_RECTANGLE;
    }

    private boolean hasDuplicatePoints(final List<Point> pointList) {
        Set<Point> pointSet = new HashSet<>(pointList);

        return pointList.size() != pointSet.size();
    }

    public static Points from(final List<Point> innerPoints) {
        return new Points(innerPoints);
    }

    public int size() {
        return innerPoints.size();
    }

    public Point get(final int index) {
        return innerPoints.get(index);
    }

    public boolean contains(final int x, final int y) {
        return innerPoints.stream()
                .anyMatch(point -> point.match(x, y));
    }

    public <T> Set<T> executeWith(Function<Point, T> functionOfPoint) {
        return innerPoints.stream()
                .map(functionOfPoint)
                .collect(Collectors.toSet());
    }
}
