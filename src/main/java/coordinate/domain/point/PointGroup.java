package coordinate.domain.point;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PointGroup {
    static final String DUPLICATED_POINT_EXCEPTION_MESSAGE = "위치가 같은 점(point)이 존재합니다. 점의 위치는 달라야 합니다.";
    static final String EMPTY_EXCEPTION_MESSAGE = "점(point)가 하나도 없습니다.";

    private final List<Point> points;

    private PointGroup(final List<Point> points) {
        this.points = points.stream()
                .sorted(Comparator.comparingInt(Point::getX))
                .sorted(Comparator.comparingInt(Point::getY))
                .collect(Collectors.toList());
        validateEmpty();
        validateDuplicate();
    }

    private void validateEmpty() {
        if (points.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicate() {
        final Set<Point> set = new HashSet<>(points);
        if (points.size() != set.size()) {
            throw new IllegalArgumentException(DUPLICATED_POINT_EXCEPTION_MESSAGE);
        }
    }

    public static PointGroup of(final List<Point> points) {
        return new PointGroup(points);
    }

    public Point get(final int index) {
        return points.get(index);
    }

    public boolean matchSize(final int size) {
        return points.size() == size;
    }

    public int size() {
        return points.size();
    }
}
