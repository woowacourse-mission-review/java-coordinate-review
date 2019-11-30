package domain.figure;

import domain.Point;
import domain.graph.Graph;
import domain.Points;

import java.util.List;

public class Line implements Figure {
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
        return points.calculateDistance(0, 1);
    }
}
