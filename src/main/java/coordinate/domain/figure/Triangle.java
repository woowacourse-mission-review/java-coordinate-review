package coordinate.domain.figure;

import coordinate.domain.point.Point;
import coordinate.domain.point.PointGroup;

public class Triangle extends AbstractFigure {
    static final int SIZE_OF_POINTS = 3;

    public Triangle(final PointGroup pointGroup) {
        super(pointGroup, SIZE_OF_POINTS);
    }

    public static Triangle of(final PointGroup pointGroup) {
        return new Triangle(pointGroup);
    }

    @Override
    public int size() {
        return SIZE_OF_POINTS;
    }

    /**
     * Heron's formula
     * s = (a+ b + c) / 2
     * 넓이 = √s(s-a)(s-b)(s-c)
     *
     * @return 넓이
     */
    @Override
    public double area() {
        final Point point1 = pointGroup.get(0);
        final Point point2 = pointGroup.get(1);
        final Point point3 = pointGroup.get(2);

        final double a = point1.distanceTo(point2);
        final double b = point2.distanceTo(point3);
        final double c = point3.distanceTo(point1);

        final double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getName() {
        return "삼각형";
    }
}
