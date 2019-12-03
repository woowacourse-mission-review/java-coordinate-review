package coordinatecalculator.domain.result;

import coordinatecalculator.domain.figure.Point;

import java.util.Collections;
import java.util.List;

public class Result {

    private final List<Point> points;
    private final List<String> attributeMessages;

    private Result(final List<Point> points, final List<String> attributesMessages) {
        this.points = Collections.unmodifiableList(points);
        this.attributeMessages = Collections.unmodifiableList(attributesMessages);
    }

    public static Result of(final List<Point> points, final List<String> attributesMessages) {
        return new Result(points, attributesMessages);
    }

    public boolean contains(final Point point) {
        return points.contains(point);
    }

    public List<String> getAttributeMessages() {
        return attributeMessages;
    }
}
