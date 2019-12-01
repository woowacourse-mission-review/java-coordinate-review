package coordinatecalculator.domain.figure.triangle;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import coordinatecalculator.domain.figure.AttributeCreator;
import coordinatecalculator.domain.figure.Figure;
import coordinatecalculator.domain.figure.Point;
import coordinatecalculator.domain.result.Result;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Triangle implements Figure {

    private final List<AttributeCreator> attributeCreators = Lists.newArrayList(new TriangleAreaAttributeCreator());

    private final List<Point> points;

    public Triangle(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> points) {
        if (points.size() != 3) {
            throw new IllegalArgumentException();
        }
        if (points.size() != Sets.newHashSet(points).size()) {
            throw new IllegalArgumentException();
        }
        validateSlope(points);
    }

    private void validateSlope(List<Point> points) {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);

        int leftHandSide = (point2.yValue() - point1.yValue()) * (point3.xValue() - point1.xValue());
        int rightHandSide = (point3.yValue() - point1.yValue()) * (point2.xValue() - point1.xValue());

        if (leftHandSide == rightHandSide) {
            throw new IllegalArgumentException();
        }
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
        final Triangle triangle = (Triangle) o;
        return points.containsAll(triangle.points) && triangle.points.containsAll(points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Sets.newHashSet(points));
    }
}
