package domain;

public class Point {
    private Coordinate xCoordinate;
    private Coordinate yCoordinate;
    public Point(int rawXCoordinate, int rawYCoordinate) {
        this.xCoordinate = Coordinates.retrieveValue(rawXCoordinate);
        this.yCoordinate = Coordinates.retrieveValue(rawYCoordinate);
    }

    public Coordinate getxCoordinate() {
        return xCoordinate;
    }

    public Coordinate getyCoordinate() {
        return yCoordinate;
    }
}
