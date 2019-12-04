package coordinates.domain.point;

import coordinates.exception.DuplicatePointsException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Points {

    private final List<Point> innerPoints;

    private Points(final List<Point> innerPoints) {
        validatePoints(innerPoints);

        this.innerPoints = innerPoints;
    }

    private void validatePoints(final List<Point> innerPoints) {
        if (hasDuplicatePoints(innerPoints)) {
            throw new DuplicatePointsException();
        }
    }

    private boolean hasDuplicatePoints(final List<Point> pointList) {
        Set<Point> pointSet = new HashSet<>(pointList);

        return pointList.size() != pointSet.size();
    }

    public static Points from(final List<Point> innerPoints) {
        return new Points(innerPoints);
    }

    public int size() {
        return innerPoints.size();
    }

    public Point get(final int index) {
        return innerPoints.get(index);
    }

    public boolean contains(final int x, final int y) {
        return innerPoints.contains(Point.of(x, y));
    }

    public <T> Set<T> modifyUniqueWith(Function<Point, T> functionOfPoint) {
        return innerPoints.stream()
                .map(functionOfPoint)
                .collect(Collectors.toSet());
    }
}
