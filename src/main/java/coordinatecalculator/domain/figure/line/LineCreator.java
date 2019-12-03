package coordinatecalculator.domain.figure.line;

import coordinatecalculator.domain.figure.FigureCreator;
import coordinatecalculator.domain.figure.Point;

import java.util.List;

public class LineCreator implements FigureCreator<Line> {

    @Override
    public boolean canCreate(final List<Point> points) {
        return !Line.isInvalidLine(points);
    }

    @Override
    public Line create(final List<Point> points) {
        return Line.of(points);
    }
}
