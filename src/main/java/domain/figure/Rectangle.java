package domain.figure;

import domain.Graph;
import domain.Points;

import java.util.List;

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
        List<Double> perpendicularSidesSizes = points.findPerpendicularSidesSizes();
        return perpendicularSidesSizes.stream()
                .reduce(1.0, (a, b) -> a * b);
    }
}
