package domain.figure;

import domain.Point;
import domain.Points;
import domain.graph.Graph;

import java.util.List;

public class Line implements Figure {
    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;
    private Points points;

    public Line(Points points) {
        this.points = points;
    }

    @Override
    public Graph drawGraph() {
        String finalStatement = "선분의 길이는 " + calculateDistanceOrArea() + "입니다.";
        List<Point> points = this.points.getPoints();
        return new Graph(finalStatement, points);
    }

    @Override
    public double calculateDistanceOrArea() {
        return points.calculateDistance(FIRST_POINT_INDEX, SECOND_POINT_INDEX);
    }
}
