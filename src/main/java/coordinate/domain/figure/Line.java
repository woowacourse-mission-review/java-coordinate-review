package coordinate.domain.figure;

import coordinate.domain.point.PointGroup;

public class Line extends AbstractFigure {
    static final int SIZE_OF_POINTS = 2;
    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;

    public Line(final PointGroup pointGroup) {
        super(pointGroup, SIZE_OF_POINTS);
    }

    public static Line of(final PointGroup pointGroup) {
        return new Line(pointGroup);
    }

    @Override
    public double area() {
        return pointGroup.calculateDistance(FIRST_POINT_INDEX, SECOND_POINT_INDEX);
    }

    @Override
    public int size() {
        return SIZE_OF_POINTS;
    }

    @Override
    public String getName() {
        return "선";
    }
}
