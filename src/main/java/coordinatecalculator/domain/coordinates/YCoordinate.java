package coordinatecalculator.domain.coordinates;

import com.google.common.collect.Maps;
import coordinatecalculator.domain.coordinates.exception.InvalidCoordinateException;

import java.util.Map;
import java.util.Objects;

public class YCoordinate implements Coordinate {

    public static final int MAX_Y_COORDINATE = 24;
    public static final int MIN_Y_COORDINATE = 1;

    public static final String Y_COORDINATE_INVALID_EXCEPTION_MESSAGE = String.format("Y 좌표는 %d~%d 사이의 정수여야 합니다."
            , MIN_Y_COORDINATE, MAX_Y_COORDINATE);

    private static final Map<Integer, YCoordinate> yCoordinatePool = Maps.newHashMap();

    private final CoordinateValue coordinate;

    private YCoordinate(final int coordinate) {
        validate(coordinate);
        this.coordinate = CoordinateValue.of(coordinate);
    }

    private void validate(final int coordinate) {
        if (coordinate > MAX_Y_COORDINATE) {
            throw new InvalidCoordinateException(Y_COORDINATE_INVALID_EXCEPTION_MESSAGE);
        }
        if (coordinate < MIN_Y_COORDINATE) {
            throw new InvalidCoordinateException(Y_COORDINATE_INVALID_EXCEPTION_MESSAGE);
        }
    }

    public static YCoordinate of(final int coordinate) {
        if (yCoordinatePool.containsKey(coordinate)) {
            return yCoordinatePool.get(coordinate);
        }
        YCoordinate yCoordinate = new YCoordinate(coordinate);
        yCoordinatePool.put(coordinate, yCoordinate);
        return yCoordinate;
    }

    public int value() {
        return coordinate.value();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final YCoordinate that = (YCoordinate) o;
        return coordinate.equals(that.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
