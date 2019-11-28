package coordinates.domain.point;

import java.util.HashMap;
import java.util.Map;

public class UnitCoordinatePool {

    private static final Map<Integer, UnitCoordinate> COORDINATES = new HashMap<>();

    private UnitCoordinatePool() {
    }

    public static UnitCoordinate get(final int value) {
        if (COORDINATES.containsKey(value)) {
            return COORDINATES.get(value);
        }

        UnitCoordinate newUnitCoordinate = new UnitCoordinate(value);
        COORDINATES.put(value, newUnitCoordinate);

        return newUnitCoordinate;
    }
}
