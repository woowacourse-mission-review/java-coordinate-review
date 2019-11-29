package coordinates.domain.point;

import java.util.HashMap;
import java.util.Map;

public class RelativeCoordinatePool {

    private static final Map<Integer, RelativeCoordinate> RELATIVE_COORDINATES = new HashMap<>();

    private RelativeCoordinatePool() {
    }

    public static RelativeCoordinate get(final int value) {
        if (RELATIVE_COORDINATES.containsKey(value)) {
            return RELATIVE_COORDINATES.get(value);
        }

        RelativeCoordinate newRelativeCoordinate = RelativeCoordinate.from(value);
        RELATIVE_COORDINATES.put(value, newRelativeCoordinate);

        return newRelativeCoordinate;
    }
}
