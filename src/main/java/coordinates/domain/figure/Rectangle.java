package coordinates.domain.figure;

import coordinates.domain.point.Point;
import coordinates.domain.point.Points;
import coordinates.domain.point.unitcoordinate.UnitCoordinate;
import coordinates.exception.IllegalFigureCreationException;
import coordinates.exception.NotRectangleException;

import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Rectangle implements Figure {

    private static final int KINDS_OF_COORDINATES_IN_RECTANGLE = 2;
    public static final int SIZE_OF_POINTS_IN_RECTANGLE = 4;

    private final Points points;

    private Rectangle(final Points points) {
        if (isNotSquare(points)) {
            throw new IllegalFigureCreationException();
        }

        if (isNotRectangle(points)) {
            throw new NotRectangleException();
        }

        this.points = points;
    }

    private boolean isNotSquare(final Points points) {
        return points.size() != SIZE_OF_POINTS_IN_RECTANGLE;
    }

    private boolean isNotRectangle(final Points points) {
        return checkKindsOfCoordinate(points, Point::getX) || checkKindsOfCoordinate(points, Point::getY);
    }

    private boolean checkKindsOfCoordinate(final Points points, final ToIntFunction<Point> toIntFunction) {
        Set<Integer> numberSet = points.modifyUniqueWith(toIntFunction::applyAsInt);

        return numberSet.size() != KINDS_OF_COORDINATES_IN_RECTANGLE;
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

    private UnitCoordinate calculateSideLength(Function<Point, UnitCoordinate> functionOfGettingCoordinate
            , BinaryOperator<UnitCoordinate> functionOfCalculatingPositiveDifference) {
        return points.modifyUniqueWith(functionOfGettingCoordinate)
                .stream()
                .reduce(functionOfCalculatingPositiveDifference)
                .orElseThrow(RuntimeException::new);
    }
}
