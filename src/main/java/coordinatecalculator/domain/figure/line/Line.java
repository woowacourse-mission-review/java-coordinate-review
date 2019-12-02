package coordinatecalculator.domain.figure.line;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import coordinatecalculator.domain.figure.AttributeCreator;
import coordinatecalculator.domain.figure.Figure;
import coordinatecalculator.domain.figure.Point;
import coordinatecalculator.domain.figure.exception.InvalidFigureCreationException;

import java.util.List;
import java.util.Objects;

public class Line extends Figure {

    public static final String INVALID_LINE_CREATION_EXCEPTION_MESSAGE = "직선은 같지 않은 두 개의 점을 입력해야 합니다.";
    private static final int LINE_POINT_SIZE = 2;

    private static final List<AttributeCreator> LINE_ATTRIBUTE_CREATOR = Lists.newArrayList(new LineLengthAttributeCreator());

    private Line(final List<Point> points) {
        super(points, LINE_ATTRIBUTE_CREATOR);
    }

    public static Line of(final List<Point> points) {
        if (isInvalidLine(points)) {
            throw new InvalidFigureCreationException(INVALID_LINE_CREATION_EXCEPTION_MESSAGE);
        }
        return new Line(points);
    }

    static boolean isInvalidLine(final List<Point> points) {
        if (points.size() != LINE_POINT_SIZE) {
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
