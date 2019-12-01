package coordinatecalculator.domain.figure.triangle;

import coordinatecalculator.domain.figure.AttributeCreator;
import coordinatecalculator.domain.figure.Point;

import java.util.List;

public class TriangleAreaAttributeCreator implements AttributeCreator {

    public static final String TRIANGLE_AREA_ATTRIBUTES_MESSAGE_FORMAT = "삼각형 넓이는 %.2f 입니다.";

    @Override
    public String create(final List<Point> points) {
        return String.format(TRIANGLE_AREA_ATTRIBUTES_MESSAGE_FORMAT, calculateArea(points));
    }

    private double calculateArea(List<Point> points) {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);

        double distance1 = point1.calculateDistance(point2);
        double distance2 = point2.calculateDistance(point3);
        double distance3 = point3.calculateDistance(point1);

        return applyHeronFormula(distance1, distance2, distance3);
    }

    private double applyHeronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
