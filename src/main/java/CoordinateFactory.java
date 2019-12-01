import java.util.HashMap;
import java.util.Map;

public class CoordinateFactory {
    private static final Map<Integer, Coordinate> bucket = new HashMap<>();

    static {
        for (int index = Coordinate.MIN_VALUE; index < Coordinate.MAX_VALUE; index++) {
            bucket.put(index, new Coordinate(index));
        }
    }

    public static Coordinate get(String inputValue) {
        Integer value = Coordinate.validateAndReturn(inputValue);
        return bucket.get(value);
    }
}
