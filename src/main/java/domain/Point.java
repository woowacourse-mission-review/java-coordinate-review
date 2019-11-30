package domain;

import exception.UnavailabeCoordinateException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Point {
    private static final int X_COORDINATE_POSITION = 0;
    private static final int Y_COORDINATE_POSITION = 1;
    private static final int NECESSARY_COORDINATES_SIZE = 2;
    private static final String COORDINATE_DELIMITER = ",";
    private Coordinate xCoordinate;
    private Coordinate yCoordinate;

    public Point(String rawCoordinates) {
        List<String> coordinates = Arrays.asList(rawCoordinates.split(COORDINATE_DELIMITER));
        checkCoordinatesQuantity(coordinates);
        try {
            this.xCoordinate = Coordinates.retrieveValue(Integer.parseInt(coordinates.get(X_COORDINATE_POSITION)));
            this.yCoordinate = Coordinates.retrieveValue(Integer.parseInt(coordinates.get(Y_COORDINATE_POSITION)));
        } catch(NumberFormatException e) {
            throw new UnavailabeCoordinateException();
        }
    }

    private void checkCoordinatesQuantity(List<String> coordinates) {
        if (coordinates.size() != NECESSARY_COORDINATES_SIZE) {
            throw new UnavailabeCoordinateException();
        }
    }

    public Coordinate getxCoordinate() {
        return xCoordinate;
    }

    public Coordinate getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(xCoordinate, point.xCoordinate) &&
                Objects.equals(yCoordinate, point.yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
