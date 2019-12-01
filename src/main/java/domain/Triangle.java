package domain;

import util.DoubleComparator;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Figure {
    private static final long NUM_OF_POINTS = 3;
    private final List<Point> points;

    private Triangle(List<Point> points) {
        this.points = new ArrayList<>(points);
        validateTriangle(this.points);
    }

    private void validateTriangle(List<Point> points) {
        validateNumberOfPoints(points);
        validateThreePointsNotOnSameLine(points);
    }

    private void validateNumberOfPoints(List<Point> points) {
        long numOfDistinctPoints = points.stream()
                .distinct()
                .count();

        if (numOfDistinctPoints != NUM_OF_POINTS) {
            throw new IllegalArgumentException(
                    String.format("Triangle 은 %d 개의 서로 다른 점으로 이루어져야 합니다.", NUM_OF_POINTS));
        }
    }

    private void validateThreePointsNotOnSameLine(List<Point> points) {
        Vector v1 = Vector.of(points.get(0), points.get(1));
        Vector v2 = Vector.of(points.get(0), points.get(2));

        // Geometrical definition of inner product...
        if (DoubleComparator.equals(
                Math.abs(v1.innerProduct(v2)), v1.size() * v2.size())) {
            throw new IllegalArgumentException("삼각형의 세 점이 한 직선상에 존재하면 안 됩니다.");
        }
    }

    public static Triangle of(List<Point> points) {
        return new Triangle(points);
    }

    @Override
    public FigureType getType() {
        return FigureType.TRIANGLE;
    }

    @Override
    public List<Point> getPoints() {
        return null;
    }

    @Override
    public double calculate() {
        Vector v1 = Vector.of(points.get(0), points.get(1));
        Vector v2 = Vector.of(points.get(0), points.get(2));

        return Math.sqrt(Math.pow(v1.size(), 2.0) * Math.pow(v2.size(), 2.0) - Math.pow(v1.innerProduct(v2), 2.0)) / 2.0;
    }
}
