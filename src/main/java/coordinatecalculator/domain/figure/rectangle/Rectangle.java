package coordinatecalculator.domain.figure.rectangle;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import coordinatecalculator.domain.figure.AttributeCreator;
import coordinatecalculator.domain.figure.Figure;
import coordinatecalculator.domain.figure.Point;
import coordinatecalculator.domain.figure.triangle.TriangleAreaAttributeCreator;
import coordinatecalculator.domain.result.Result;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rectangle implements Figure {

    private final List<AttributeCreator> attributeCreators = Lists.newArrayList(new TriangleAreaAttributeCreator());

    private List<Point> points;

    public Rectangle(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> points) {
        if (points.size() != 4) {
            throw new IllegalArgumentException();
        }
        if (points.size() != Sets.newHashSet(points).size()) {
            throw new IllegalArgumentException();
        }
        validatePair(points);
    }

    private void validatePair(final List<Point> points) {
        List<Integer> xPoints = findPair(points, Point::xValue);
        List<Integer> yPoints = findPair(points, Point::yValue);

        if (xPoints.size() != 2 || yPoints.size() != 2) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> findPair(final List<Point> points, final Function<Point, Integer> pairFunction) {
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
    public Result createResult() {
        List<String> attributesMessages = attributeCreators.stream()
                .map(attributeCreator -> attributeCreator.create(points))
                .collect(Collectors.toList());

        return Result.of(points, attributesMessages);
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
