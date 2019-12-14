package coordinate.domain.figure;

import coordinate.domain.point.PointGroup;

public abstract class AbstractFigure implements Figure {
    public static final String POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE = "%s의 점(Point)은 %d개야 합니다.";

    protected final PointGroup pointGroup;

    private AbstractFigure(final PointGroup pointGroup) {
        this.pointGroup = pointGroup;
    }

    public AbstractFigure(final PointGroup pointGroup, final int sizeOfPointGroup) {
        this(pointGroup);
        validateSize(sizeOfPointGroup);
    }

    @Override
    public void validateSize(final int sizeOfPointGroup) {
        if (!pointGroup.matchSize(sizeOfPointGroup)) {
            throw new IllegalArgumentException(String.format(POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE, getName(), sizeOfPointGroup));
        }
    }
}
