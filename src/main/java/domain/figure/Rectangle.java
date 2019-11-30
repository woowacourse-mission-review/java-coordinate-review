package domain.figure;

import domain.Graph;
import domain.Points;

public class Rectangle implements Figure {
    private Points points;

    public Rectangle(Points points) {
        checkIfRectangle(points);
        this.points = points;
    }

    private void checkIfRectangle(Points points) {
        points.isSpreadRectangly();
    }

    @Override
    public Graph drawGraph() {
        return null;
    }

    @Override
    public double calculateDistanceOrArea() {
        return 0;
    }
}
