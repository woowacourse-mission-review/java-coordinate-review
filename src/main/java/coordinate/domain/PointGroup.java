package coordinate.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PointGroup {
    static final String DUPLICATED_POINT_EXCEPTION_MESSAGE = "Point는 중복될 수 없습니다.";

    final Set<Point> points;

    private PointGroup(final List<Point> points) {
        this.points = new HashSet<>(points);
        validateDuplicate(points);
    }

    private void validateDuplicate(final List<Point> points) {
        if (points.size() != size()) {
            throw new IllegalArgumentException(DUPLICATED_POINT_EXCEPTION_MESSAGE);
        }
    }

    public static PointGroup of(final List<Point> points) {
        return new PointGroup(points);
    }

    public int size() {
        return points.size();
    }
}
