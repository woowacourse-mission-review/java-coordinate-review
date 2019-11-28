package coordinates.domain.point;

import coordinates.exception.OutOfYCoordinateBoundException;

public class YCoordinate extends UnitCoordinate {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 24;

    private YCoordinate(final int y) {
        super(y);

        if (isOutOfBound(super.getValue())) {
            throw new OutOfYCoordinateBoundException();
        }
    }

    private boolean isOutOfBound(final int value) {
        return value < LOWER_BOUND || value > UPPER_BOUND;
    }

    public static YCoordinate from(final int y) {
        return new YCoordinate(y);
    }
}
