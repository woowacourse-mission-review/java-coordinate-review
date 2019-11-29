package domain;

import exception.UnavailabeCoordinateException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Coordinates {
    private static final int NUMBER_LOWER_BOUNDARY = 0;
    private static final int NUMBER_UPPER_BOUNDARY = 24;
    private static Map<Integer, Coordinate> coordinates = new HashMap<>();

    static {
        IntStream.rangeClosed(NUMBER_LOWER_BOUNDARY, NUMBER_UPPER_BOUNDARY)
                .forEach(index -> coordinates.put(index, new Coordinate(index)));
    }

    public static Coordinate retrieveValue(int coordinate) {
        Coordinate retrievedCoordinate = coordinates.get(coordinate);
        if (retrievedCoordinate == null) {
            throw new UnavailabeCoordinateException();
        }
        return coordinates.get(coordinate);
    }

    public static int size() {
        return coordinates.size();
    }
}
