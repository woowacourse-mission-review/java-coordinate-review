package coordinates.domain.figure;

import coordinates.domain.point.Point;
import coordinates.domain.point.Points;
import coordinates.domain.point.unitcoordinate.UnitCoordinate;
import coordinates.exception.IllegalFigureCreationException;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rectangle implements Figure {

    private static final int SIZE_OF_POINTS_IN_RECTANGLE = 4;

    private final Points points;

    private Rectangle(final Points points) {
        if (points.size() != SIZE_OF_POINTS_IN_RECTANGLE) {
            throw new IllegalFigureCreationException();
        }

        this.points = points;
    }

    public static Rectangle from(Points points) {
        return new Rectangle(points);
    }

    @Override
    public int size() {
        return SIZE_OF_POINTS_IN_RECTANGLE;
    }

    @Override
    public double area() {
        UnitCoordinate distanceOfX = calculateSideLength(Point::getXCoordinate, UnitCoordinate::calculatePositiveDifference);
        UnitCoordinate distanceOfY = calculateSideLength(Point::getYCoordinate, UnitCoordinate::calculatePositiveDifference);

        return distanceOfX.multiply(distanceOfY);
    }

    private <T> T calculateSideLength(Function<Point, T> getCoordinateOfPoint, BinaryOperator<T> calculatePositiveDifference) {
        return points.stream()
                .map(getCoordinateOfPoint)
                .collect(Collectors.toSet())
                .stream()
                .reduce(calculatePositiveDifference)
                .orElseThrow(RuntimeException::new);
    }
}
