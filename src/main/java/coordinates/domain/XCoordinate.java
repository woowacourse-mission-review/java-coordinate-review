package coordinates.domain;

import coordinates.exception.OutOfXCoordinateBoundException;

import java.util.Objects;

public class XCoordinate {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 24;

    private final int x;

    private XCoordinate(final int x) {
        if (isOutOfBound(x)) {
            throw new OutOfXCoordinateBoundException();
        }

        this.x = x;
    }

    private boolean isOutOfBound(final int x) {
        return x < LOWER_BOUND || x > UPPER_BOUND;
    }

    public static XCoordinate from(final int x) {
        return new XCoordinate(x);
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final XCoordinate that = (XCoordinate) o;
        return x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
