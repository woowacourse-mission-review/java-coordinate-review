package coordinates.domain;

import coordinates.exception.OutOfYCoordinateBoundException;

import java.util.Objects;

public class YCoordinate {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 24;

    private final int y;

    private YCoordinate(final int y) {
        if (isOutOfBound(y)) {
            throw new OutOfYCoordinateBoundException();
        }

        this.y = y;
    }

    private boolean isOutOfBound(final int y) {
        return y < LOWER_BOUND || y > UPPER_BOUND;
    }

    public static YCoordinate from(final int y) {
        return new YCoordinate(y);
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final YCoordinate that = (YCoordinate) o;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y);
    }
}
