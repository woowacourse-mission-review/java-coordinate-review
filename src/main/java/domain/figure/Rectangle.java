package domain.figure;

import domain.graph.Graph;
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
        String finalStatement = "직사각형의 넓이는 " + calculateDistanceOrArea() + "입니다.";
        return new Graph(finalStatement, points.getPoints());
    }

    @Override
    public double calculateDistanceOrArea() {
        List<Double> perpendicularSidesSizes = points.findPerpendicularSidesSizes();
        return perpendicularSidesSizes.stream()
                .reduce(1.0, (a, b) -> a * b);
    }
}
