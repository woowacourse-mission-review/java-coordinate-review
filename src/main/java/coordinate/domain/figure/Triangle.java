package coordinate.domain.figure;

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
        final double a = pointGroup.calculateDistance(0, 1);
        final double b = pointGroup.calculateDistance(0, 2);
        final double c = pointGroup.calculateDistance(1, 2);

        final double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getName() {
        return "삼각형";
    }
}
