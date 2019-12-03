package coordinatecalculator.domain.figure.rectangle;

import coordinatecalculator.domain.figure.FigureCreator;
import coordinatecalculator.domain.figure.Point;

import java.util.List;

public class RectangleCreator implements FigureCreator<Rectangle> {

    @Override
    public boolean canCreate(final List<Point> points) {
        return !Rectangle.isInvalidRectangle(points);
    }

    @Override
    public Rectangle create(final List<Point> points) {
        return Rectangle.of(points);
    }
}
