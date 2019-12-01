package coordinatecalculator.domain.figure.rectangle;

import com.google.common.collect.Sets;
import coordinatecalculator.domain.figure.FigureCreator;
import coordinatecalculator.domain.figure.Point;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RectangleCreator implements FigureCreator<Rectangle> {

    @Override
    public boolean canCreate(final List<Point> points) {
        if (points.size() != 4) {
            return false;
        }
        if (points.size() != Sets.newHashSet(points).size()) {
            return false;
        }
        return validatePair(points);
    }

    private boolean validatePair(final List<Point> points) {
        List<Integer> xPoints = findPair(points, Point::xValue);
        List<Integer> yPoints = findPair(points, Point::yValue);

        return xPoints.size() == 2 && yPoints.size() == 2;
    }

    private List<Integer> findPair(final List<Point> points, final Function<Point, Integer> pairFunction) {
        return points.stream()
                .map(pairFunction)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Rectangle create(final List<Point> points) {
        return new Rectangle(points);
    }
}
