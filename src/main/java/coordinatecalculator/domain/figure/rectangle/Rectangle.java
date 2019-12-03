package coordinatecalculator.domain.figure.rectangle;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import coordinatecalculator.domain.figure.AttributeCreator;
import coordinatecalculator.domain.figure.Figure;
import coordinatecalculator.domain.figure.Point;
import coordinatecalculator.domain.figure.exception.InvalidFigureCreationException;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rectangle extends Figure {

    public static final String INVALID_RECTANGLE_CREATION_EXCEPTION_MESSAGE = "겹치지 않고, 기울어지지 않은 직사각형을 입력해야 합니다.";
    private static final int RECTANGLE_POINT_SIZE = 4;
    private static final int PAIR_SIZE = 2;

    private static final List<AttributeCreator> RECTANGLE_ATTRIBUTE_CREATOR = Lists.newArrayList(new RectangleAreaAttributeCreator());

    private Rectangle(final List<Point> points) {
        super(points, RECTANGLE_ATTRIBUTE_CREATOR);
    }

    public static Rectangle of(final List<Point> points) {
        if (isInvalidRectangle(points)) {
            throw new InvalidFigureCreationException(INVALID_RECTANGLE_CREATION_EXCEPTION_MESSAGE);
        }
        return new Rectangle(points);
    }

    static boolean isInvalidRectangle(final List<Point> points) {
        if (points.size() != RECTANGLE_POINT_SIZE) {
            return true;
        }
        if (points.size() != Sets.newHashSet(points).size()) {
            return true;
        }
        return isInvalidPairs(points);
    }

    private static boolean isInvalidPairs(final List<Point> points) {
        List<Integer> xPoints = findPair(points, Point::xValue);
        List<Integer> yPoints = findPair(points, Point::yValue);

        return xPoints.size() != PAIR_SIZE || yPoints.size() != PAIR_SIZE;
    }

    private static List<Integer> findPair(final List<Point> points, final Function<Point, Integer> pairFunction) {
        return points.stream()
                .map(pairFunction)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Rectangle rectangle = (Rectangle) o;
        return points.containsAll(rectangle.points) && rectangle.points.containsAll(points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Sets.newHashSet(points));
    }
}
