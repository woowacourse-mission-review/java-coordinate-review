package coordinate.domain.point;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Coordinate {
    static final String RANGE_EXCEPTION_MESSAGE = "%d~%d 사이만 입력 가능합니다.";
    private static final Map<Integer, Coordinate> CACHE = new HashMap<>();

    static final int MIN_VALUE = 0;
    static final int MAX_VALUE = 24;

    static {
        IntStream.range(MIN_VALUE, MAX_VALUE).forEach(value -> CACHE.put(value, new Coordinate(value)));
    }

    private final int value;

    private Coordinate(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(RANGE_EXCEPTION_MESSAGE, MIN_VALUE, MAX_VALUE));
        }
    }

    public static Coordinate of(final int value) {
        final Coordinate coordinate = CACHE.get(value);
        return coordinate != null ? coordinate : new Coordinate(value);
    }


    public int value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Coordinate coordinate = (Coordinate) o;
        return value == coordinate.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
