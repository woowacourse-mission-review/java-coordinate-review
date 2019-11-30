package domain.figure;

import domain.graph.Graph;
import domain.Points;

public class Triangle implements Figure {
    private static final int HALF_DIVISOR = 2;
    private Points points;

    public Triangle(Points points) {
        this.points = points;
    }

    @Override
    public Graph drawGraph() {
        String finalStatement = "직사각형의 넓이는 " + calculateDistanceOrArea() + "입니다.";
        return new Graph(finalStatement, points.getPoints());
    }

    @Override
    public double calculateDistanceOrArea() {
        double distance1 = points.calculateDistance(0, 1);
        double distance2 = points.calculateDistance(1, 2);
        double distance3 = points.calculateDistance(2, 0);
        double s = (distance1 + distance2 + distance3) / HALF_DIVISOR;
        return Math.sqrt(s * (s - distance1) * (s - distance2) * (s - distance3));
    }
}
