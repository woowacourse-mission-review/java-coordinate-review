package coordinatecalculator.domain;

public class Coordinate {

    private final int coordinate;

    private Coordinate(final int coordinate) {
        this.coordinate = coordinate;
    }

    public static Coordinate of(final int coordinate) {
        return new Coordinate(coordinate);
    }

    public int value() {
        return coordinate;
    }
}
