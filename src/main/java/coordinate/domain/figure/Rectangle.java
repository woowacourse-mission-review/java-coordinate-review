package coordinate.domain.figure;

import coordinate.domain.point.Point;
import coordinate.domain.point.PointGroup;

public class Rectangle extends AbstractFigure {
    static final int SIZE_OF_POINTS = 4;
    static final String NOT_RECTANGLE_EXCEPTION_MESSAGE = "직사각형이 아닙니다";

    public Rectangle(final PointGroup pointGroup) {
        super(pointGroup, SIZE_OF_POINTS);
        validateRectangle(pointGroup);
    }

    private void validateRectangle(final PointGroup pointGroup) {
        final Point leftBottom = pointGroup.get(0);
        final Point leftTop = pointGroup.get(2);
        final Point rightBottom = pointGroup.get(1);
        final Point rightTop = pointGroup.get(3);

        double diagonal1 = Math.hypot(leftBottom.distanceTo(leftTop), leftBottom.distanceTo(leftTop));
        double diagonal2 = Math.hypot(rightBottom.distanceTo(rightTop), rightBottom.distanceTo(rightTop));
        if (diagonal1 != diagonal2) {
            throw new IllegalArgumentException(NOT_RECTANGLE_EXCEPTION_MESSAGE);
        }
    }

    public static Rectangle of(final PointGroup pointGroup) {
        return new Rectangle(pointGroup);
    }

    @Override
    public double area() {
        final double ySideLength = pointGroup.get(0).distanceYTo(pointGroup.get(3));
        final double xSideLength = pointGroup.get(1).distanceXTo(pointGroup.get(2));
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
