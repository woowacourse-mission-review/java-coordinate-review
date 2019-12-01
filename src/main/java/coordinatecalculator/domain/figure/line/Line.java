package coordinatecalculator.domain.figure.line;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import coordinatecalculator.domain.figure.AttributeCreator;
import coordinatecalculator.domain.figure.Figure;
import coordinatecalculator.domain.figure.Point;

import java.util.List;
import java.util.Objects;

public class Line extends Figure {

    private static final List<AttributeCreator> LINE_ATTRIBUTE_CREATOR = Lists.newArrayList(new LineLengthAttributeCreator());

    private Line(final List<Point> points) {
        super(points, LINE_ATTRIBUTE_CREATOR);
    }

    public static Line of(final List<Point> points) {
        if (isInvalidLine(points)) {
            throw new IllegalArgumentException();
        }
        return new Line(points);
    }

    static boolean isInvalidLine(final List<Point> points) {
        if (points.size() != 2) {
            return true;
        }
        return Sets.newHashSet(points).size() != points.size();
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
