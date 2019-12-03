package coordinatecalculator.domain.figure.triangle;

import coordinatecalculator.domain.figure.FigureCreator;
import coordinatecalculator.domain.figure.Point;

import java.util.List;

public class TriangleCreator implements FigureCreator<Triangle> {

    @Override
    public boolean canCreate(final List<Point> points) {
        return !Triangle.isInvalidTriangle(points);
    }

    @Override
    public Triangle create(final List<Point> points) {
        return Triangle.of(points);
    }
}
