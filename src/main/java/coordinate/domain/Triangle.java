package coordinate.domain;

public class Triangle {
    static final int SIZE_OF_POINTS = 3;
    static final String POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE = "삼각형 점의 개수는 " + SIZE_OF_POINTS + "개어야 합니다.";

    private final PointGroup pointGroup;

    public Triangle(final PointGroup pointGroup) {
        if (pointGroup.size() != SIZE_OF_POINTS) {
            throw new IllegalArgumentException(POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE);
        }

        this.pointGroup = pointGroup;
    }

    public static Triangle of(final PointGroup pointGroup) {
        return new Triangle(pointGroup);
    }

    public int size() {
        return SIZE_OF_POINTS;
    }

    // TODO: 2019/12/01 refactoring
    // Heron's formula
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
}
