package domain.figure;

import domain.Points;
import domain.graph.Graph;

public class Triangle implements Figure {
    private static final int HALF_DIVISOR = 2;
    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;
    private static final int THIRD_POINT_INDEX = 2;
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
        double distance1 = points.calculateDistance(FIRST_POINT_INDEX, SECOND_POINT_INDEX);
        double distance2 = points.calculateDistance(SECOND_POINT_INDEX, THIRD_POINT_INDEX);
        double distance3 = points.calculateDistance(THIRD_POINT_INDEX, FIRST_POINT_INDEX);
        double s = (distance1 + distance2 + distance3) / HALF_DIVISOR;
        return Math.sqrt(s * (s - distance1) * (s - distance2) * (s - distance3));
    }
}
