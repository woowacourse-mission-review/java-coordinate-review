package coordinates.domain.point.unitcoordinate;

import coordinates.exception.OutOfXCoordinateBoundException;

public class XCoordinate extends UnitCoordinate {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 24;

    private XCoordinate(final int x) {
        super(x);

        if (isOutOfBound(super.getValue())) {
            throw new OutOfXCoordinateBoundException();
        }
    }

    private boolean isOutOfBound(final int value) {
        return value < LOWER_BOUND || value > UPPER_BOUND;
    }

    public static XCoordinate from(final int x) {
        return new XCoordinate(x);
    }
}
