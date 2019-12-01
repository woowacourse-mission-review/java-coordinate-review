package domain;

import java.util.ArrayList;
import java.util.List;

public class Line implements Figure {
    private static final long NUM_OF_POINTS = 2;
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = new ArrayList<>(points);
        validateLine(this.points);
    }

    private void validateLine(List<Point> points) {
        long numOfDistinctPoints = points.stream()
                .distinct()
                .count();

        if (numOfDistinctPoints != NUM_OF_POINTS) {
            throw new IllegalArgumentException(
                    String.format("Line 은 %d 개의 서로 다른 점으로 이루어져야 합니다.", NUM_OF_POINTS));
        }
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    @Override
    public FigureType getType() {
        return FigureType.LINE;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public double calculate() {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        return p1.distance(p2);
    }
}
