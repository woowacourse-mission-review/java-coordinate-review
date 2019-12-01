package coordinatecalculator.domain.figure.triangle;

import com.google.common.collect.Sets;
import coordinatecalculator.domain.figure.FigureCreator;
import coordinatecalculator.domain.figure.Point;

import java.util.List;

public class TriangleCreator implements FigureCreator<Triangle> {

    @Override
    public boolean canCreate(final List<Point> points) {
        if (points.size() != 3) {
            return false;
        }
        if (points.size() != Sets.newHashSet(points).size()) {
            return false;
        }
        return validateSlope(points);
    }

    private boolean validateSlope(final List<Point> points) {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);

        int leftHandSide = (point2.yValue() - point1.yValue()) * (point3.xValue() - point1.xValue());
        int rightHandSide = (point3.yValue() - point1.yValue()) * (point2.xValue() - point1.xValue());

        return leftHandSide == rightHandSide;
    }

    @Override
    public Triangle create(final List<Point> points) {
        return new Triangle(points);
    }
}
