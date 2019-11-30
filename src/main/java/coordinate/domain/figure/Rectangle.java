package coordinate.domain.figure;

import coordinate.domain.point.PointGroup;

public class Rectangle extends AbstractFigure {
    static final int SIZE_OF_POINTS = 4;
    static final String NOT_RECTANGLE_EXCEPTION_MESSAGE = "직사각형이 아닙니다";

    public Rectangle(final PointGroup pointGroup) {
        super(pointGroup, SIZE_OF_POINTS);
        validateRectangle(pointGroup);
    }

    private void validateRectangle(final PointGroup pointGroup) {
        double diagonal1 = Math.hypot(pointGroup.get(0).distanceTo(pointGroup.get(2)), pointGroup.get(0).distanceTo(pointGroup.get(2)));
        double diagonal2 = Math.hypot(pointGroup.get(1).distanceTo(pointGroup.get(3)), pointGroup.get(1).distanceTo(pointGroup.get(3)));
        if (diagonal1 != diagonal2) {
            throw new IllegalArgumentException(NOT_RECTANGLE_EXCEPTION_MESSAGE);
        }
    }

    public static Rectangle of(final PointGroup pointGroup) {
        return new Rectangle(pointGroup);
    }

    @Override
    public double area() {
        final double ySideLength = pointGroup.get(0).distanceTo(pointGroup.get(1));
        final double xSideLength = pointGroup.get(2).distanceTo(pointGroup.get(3));
        return xSideLength * ySideLength;
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
