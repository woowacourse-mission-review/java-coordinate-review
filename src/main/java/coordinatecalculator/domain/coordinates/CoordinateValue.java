package coordinatecalculator.domain.coordinates;

public class CoordinateValue {

    private final int coordinate;

    private CoordinateValue(final int coordinate) {
        this.coordinate = coordinate;
    }

    public static CoordinateValue of(final int coordinate) {
        return new CoordinateValue(coordinate);
    }

    public int value() {
        return coordinate;
    }
}
