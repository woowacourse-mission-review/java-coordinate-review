package coordinatecalculator.domain.coordinates;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Objects;

public class XCoordinate {

    public static final int MAX_X_COORDINATE = 24;
    public static final int MIN_X_COORDINATE = 1;

    private static final Map<Integer, XCoordinate> xCoordinatePool = Maps.newHashMap();

    private final Coordinate coordinate;

    private XCoordinate(final int coordinate) {
        validate(coordinate);
        this.coordinate = Coordinate.of(coordinate);
    }

    private void validate(final int coordinate) {
        if (coordinate > MAX_X_COORDINATE) {
            throw new IllegalArgumentException();
        }
        if (coordinate < MIN_X_COORDINATE) {
            throw new IllegalArgumentException();
        }
    }

    public static XCoordinate of(final int coordinate) {
        if (xCoordinatePool.containsKey(coordinate)) {
            return xCoordinatePool.get(coordinate);
        }
        XCoordinate xCoordinate = new XCoordinate(coordinate);
        xCoordinatePool.put(coordinate, xCoordinate);
        return xCoordinate;
    }

    public int value() {
        return coordinate.value();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final XCoordinate that = (XCoordinate) o;
        return coordinate.equals(that.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
