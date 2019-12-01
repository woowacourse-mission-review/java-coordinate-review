package coordinatecalculator.domain.figure;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Objects;

public class Line implements Figure {

    private List<Point> points;

    public Line(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> points) {
        if (points.size() != 2) {
            throw new IllegalArgumentException();
        }
        if (Sets.newHashSet(points).size() != points.size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(final Point point) {
        return points.contains(point);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Line line = (Line) o;
        return this.points.containsAll(line.points) && line.points.containsAll(this.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Sets.newHashSet(points));
    }
}
