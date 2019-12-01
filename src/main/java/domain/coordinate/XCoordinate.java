package domain.coordinate;

import java.util.HashMap;
import java.util.Map;

public class XCoordinate {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 24;
    private static final Map<Integer, XCoordinate> CACHE = new HashMap<>();
    private final int value;

    static {
        for (int x = MIN_VALUE; x <= MAX_VALUE; x++) {
            CACHE.put(x, new XCoordinate(x));
        }
    }

    private XCoordinate(int value) {
        this.value = value;
    }

    public static XCoordinate from(int value) {
        validateRange(value);
        return CACHE.get(value);
    }

    private static void validateRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("X 좌표 값은 %d 이상 %d 이하여야 합니다.",
                    MIN_VALUE, MAX_VALUE));
        }
    }

    public int getValue() {
        return value;
    }
}
