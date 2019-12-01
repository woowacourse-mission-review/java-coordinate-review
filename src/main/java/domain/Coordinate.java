package domain;

import domain.exception.InvalidCoordinateException;

import java.util.Objects;

public class Coordinate {
    public static final Integer MAX_VALUE = 24;
    public static final Integer MIN_VALUE = 0;

    private final Integer value;

    public Coordinate(String value) {
        this.value = validateAndReturn(value);
    }

    public Coordinate(Integer value) {
        validate(value);
        this.value = value;
    }

    public static Integer validateAndReturn(String inputValue) {
        try {
            Integer value = Integer.parseInt(inputValue);
            validate(value);
            return value;
        } catch (NumberFormatException e) {
            throw new InvalidCoordinateException();
        }
    }

    public static void validate(Integer value) {
        if (value > MAX_VALUE || value < MIN_VALUE) {
            throw new InvalidCoordinateException();
        }
    }

    public Integer minus(Coordinate another) {
        return value - another.value;
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
