package coordinatecalculator.domain.figure.line;

import com.google.common.collect.Sets;
import coordinatecalculator.domain.figure.FigureCreator;
import coordinatecalculator.domain.figure.Point;

import java.util.List;

public class LineCreator implements FigureCreator<Line> {

    @Override
    public boolean canCreate(final List<Point> points) {
        if (points.size() != 2) {
            return false;
        }
        return Sets.newHashSet(points).size() == points.size();
    }

    @Override
    public Line create(final List<Point> points) {
        return new Line(points);
    }
}
