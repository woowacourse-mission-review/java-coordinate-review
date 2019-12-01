package coordinatecalculator.domain.figure.rectangle;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import coordinatecalculator.domain.figure.AttributeCreator;
import coordinatecalculator.domain.figure.Figure;
import coordinatecalculator.domain.figure.Point;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rectangle extends Figure {

    private static final List<AttributeCreator> RECTANGLE_ATTRIBUTE_CREATOR = Lists.newArrayList(new RectangleAreaAttributeCreator());

    private Rectangle(final List<Point> points) {
        super(points, RECTANGLE_ATTRIBUTE_CREATOR);
    }

    public static Rectangle of(final List<Point> points) {
        if (isInvalidRectangle(points)) {
            throw new IllegalArgumentException();
        }
        return new Rectangle(points);
    }

    static boolean isInvalidRectangle(final List<Point> points) {
        if (points.size() != 4) {
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

        return xPoints.size() != 2 || yPoints.size() != 2;
    }

    private static List<Integer> findPair(final List<Point> points, final Function<Point, Integer> pairFunction) {
        return points.stream()
                .map(pairFunction)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public boolean contains(final Point point) {
        return points.contains(point);
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
