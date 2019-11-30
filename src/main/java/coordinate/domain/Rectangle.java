package coordinate.domain;

public class Rectangle {
    static final int SIZE_OF_POINTS = 4;
    static final String POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE = "Rectangle의 PointGroup 개수는 " + SIZE_OF_POINTS + "이어야 합니다.";

    private final PointGroup pointGroup;

    // TODO: 2019/11/30 유효성 검사 리팩토링
    public Rectangle(final PointGroup pointGroup) {
        if (pointGroup.size() != SIZE_OF_POINTS) {
            throw new IllegalArgumentException(POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE);
        }
        validateRectangle(pointGroup);
        this.pointGroup = pointGroup;
    }

    // TODO: 2019/11/30 리팩토링
    private void validateRectangle(final PointGroup pointGroup) {
        double diagonal1 = Math.hypot(pointGroup.get(0).distanceTo(pointGroup.get(2)), pointGroup.get(0).distanceTo(pointGroup.get(2)));
        double diagonal2 = Math.hypot(pointGroup.get(1).distanceTo(pointGroup.get(3)), pointGroup.get(1).distanceTo(pointGroup.get(3)));
        if (diagonal1 != diagonal2) {
            throw new IllegalArgumentException("직사각형이 아닙니다");
        }
    }

    public static Rectangle of(final PointGroup pointGroup) {
        return new Rectangle(pointGroup);
    }

    public int size() {
        return SIZE_OF_POINTS;
    }

    // TODO: 2019/11/30 깔끔하게 리팩토링
    public double area() {
        final double ySideLength = pointGroup.get(0).distanceTo(pointGroup.get(1));
        final double xSideLength = pointGroup.get(2).distanceTo(pointGroup.get(3));
        return xSideLength * ySideLength;
    }
}
