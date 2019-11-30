package coordinate.domain;

public class Line {
    static final int SIZE_OF_POINTS = 2;
    static final String POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE = "Line의 PointGroup 개수는 " + SIZE_OF_POINTS + "이어야 합니다.";
    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;

    private final PointGroup pointGroup;

    public Line(final PointGroup pointGroup) {
        if (pointGroup.size() != SIZE_OF_POINTS) {
            throw new IllegalArgumentException(POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE);
        }
        this.pointGroup = pointGroup;
    }

    public static Line of(final PointGroup pointGroup) {
        return new Line(pointGroup);
    }

    public double length() {
        final Point point1 = pointGroup.get(FIRST_POINT_INDEX);
        final Point point2 = pointGroup.get(SECOND_POINT_INDEX);
        return point1.distanceTo(point2);
    }

    public int size() {
        return SIZE_OF_POINTS;
    }
}
