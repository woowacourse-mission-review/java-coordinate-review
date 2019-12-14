package coordinate.domain.figure;

import coordinate.domain.point.PointGroup;

public class Rectangle extends AbstractFigure {
    static final int SIZE_OF_POINTS = 4;
    static final String NOT_RECTANGLE_EXCEPTION_MESSAGE = "직사각형이 아닙니다";
    private static final int LEFT_BOTTOM = 0;
    private static final int RIGHT_BOTTOM = 1;
    private static final int LEFT_TOP = 2;
    private static final int RIGHT_TOP = 3;

    public Rectangle(final PointGroup pointGroup) {
        super(pointGroup, SIZE_OF_POINTS);
        validateRectangle(pointGroup);
    }

    private void validateRectangle(final PointGroup pointGroup) {
        final double distanceOfLeft = pointGroup.calculateDistance(LEFT_BOTTOM, LEFT_TOP);
        final double distanceOfRight = pointGroup.calculateDistance(RIGHT_BOTTOM, RIGHT_TOP);

        final double diagonal1 = Math.hypot(distanceOfLeft, distanceOfLeft);
        final double diagonal2 = Math.hypot(distanceOfRight, distanceOfRight);
        if (diagonal1 != diagonal2) {
            throw new IllegalArgumentException(NOT_RECTANGLE_EXCEPTION_MESSAGE);
        }
    }

    public static Rectangle of(final PointGroup pointGroup) {
        return new Rectangle(pointGroup);
    }

    @Override
    public double area() {
        final double xSideLength = pointGroup.calculateDistanceX(LEFT_BOTTOM, RIGHT_TOP);
        final double ySideLength = pointGroup.calculateDistanceY(RIGHT_BOTTOM, RIGHT_TOP);
        return Math.abs(xSideLength * ySideLength);
    }

    @Override
    public int size() {
        return SIZE_OF_POINTS;
    }

    @Override
    public String getName() {
        return "직사각형";
    }
}
