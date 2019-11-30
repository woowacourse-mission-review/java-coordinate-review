package domain;

public class Coordinate {
    private static final int SQUARED = 2;
    private final int value;
    public Coordinate(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public double calculateSquaredDistance(Coordinate otherCoordinate) {
        return Math.pow(this.value - otherCoordinate.value, 2);
    }
}
