package coordinate.domain;

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

    // TODO: 2019/12/01 refactoring
    // Heron's formula
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
