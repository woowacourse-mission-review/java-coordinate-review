package coordinatecalculator.domain.figure.triangle;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import coordinatecalculator.domain.figure.AttributeCreator;
import coordinatecalculator.domain.figure.Figure;
import coordinatecalculator.domain.figure.Point;

import java.util.List;
import java.util.Objects;

public class Triangle extends Figure {

    private static final List<AttributeCreator> TRIANGLE_ATTRIBUTE_CREATOR = Lists.newArrayList(new TriangleAreaAttributeCreator());

    private Triangle(final List<Point> points) {
        super(points, TRIANGLE_ATTRIBUTE_CREATOR);
    }

    public static Triangle of(final List<Point> points) {
        if (isInvalidTriangle(points)) {
            throw new IllegalArgumentException();
        }
        return new Triangle(points);
    }

    static boolean isInvalidTriangle(final List<Point> points) {
        if (points.size() != 3) {
            return true;
        }
        if (points.size() != Sets.newHashSet(points).size()) {
            return true;
        }
        return isInvalidSlope(points);
    }

    private static boolean isInvalidSlope(List<Point> points) {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);

        int leftHandSide = (point2.yValue() - point1.yValue()) * (point3.xValue() - point1.xValue());
        int rightHandSide = (point3.yValue() - point1.yValue()) * (point2.xValue() - point1.xValue());

        return leftHandSide == rightHandSide;
    }

    @Override
    public boolean contains(final Point point) {
        return points.contains(point);
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
