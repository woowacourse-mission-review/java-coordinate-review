package domain.figure;

import domain.Graph;
import domain.Points;

public class Line implements Figure {
    private Points points;

    public Line(Points points) {
        this.points = points;
    }

    @Override
    public Graph drawGraph() {
        return null;
    }

    @Override
    public double calculateDistanceOrArea() {
        return points.calculateDistance(0,1);
    }
}
