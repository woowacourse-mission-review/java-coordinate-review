package domain.figure;

import domain.Graph;
import domain.Points;

public class Triangle implements Figure {
    private Points points;

    public Triangle(Points points) {
        this.points = points;
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
