package coordinates.domain;

import coordinates.exception.DuplicatePointsException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Points {

    private final List<Point> innerPoints;

    private Points(final List<Point> innerPoints) {
        if (hasDuplicatePoints(innerPoints)) {
            throw new DuplicatePointsException();
        }

        // TODO: 27/11/2019 check rectangle

        this.innerPoints = innerPoints;
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
        return innerPoints.stream()
                .anyMatch(point -> point.match(x, y));
    }
}
