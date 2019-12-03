package coordinatecalculator.domain.figure.rectangle;

import coordinatecalculator.domain.figure.AttributeCreator;
import coordinatecalculator.domain.figure.Point;

import java.util.List;
import java.util.function.BiPredicate;

public class RectangleAreaAttributeCreator implements AttributeCreator {

    public static final String RECTANGLE_AREA_ATTRIBUTES_MESSAGE_FORMAT = "사각형 넓이는 %.2f 입니다.";

    @Override
    public String create(final List<Point> points) {
        return String.format(RECTANGLE_AREA_ATTRIBUTES_MESSAGE_FORMAT, calculateArea(points));
    }

    private double calculateArea(final List<Point> points) {
        Point target = points.get(0);
        Point xPair = getPair(points, target, (point1, point2) -> point1.xValue() == point2.xValue());
        Point yPair = getPair(points, target, (point1, point2) -> point1.yValue() == point2.yValue());

        return target.calculateDistance(xPair) * target.calculateDistance(yPair);
    }

    private Point getPair(final List<Point> points, final Point target, final BiPredicate<Point, Point> predicate) {
        return points.stream()
                .filter(point -> predicate.test(point, target))
                .filter(point -> !point.equals(target))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
