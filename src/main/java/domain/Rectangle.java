package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rectangle implements Figure {
    private static final long NUM_OF_POINTS = 4;
    private final List<Point> points;

    public Rectangle(List<Point> points) {
        this.points = new ArrayList<>(points);
        sortPoints(this.points);
        validateRectangle(this.points);
    }

    private void sortPoints(List<Point> points) {
        Collections.sort(points);
        Point tmp = points.get(0);
        points.set(0, points.get(1));
        points.set(1, tmp);
    }

    private void validateRectangle(List<Point> points) {
        validateNumberOfPoints(points);
        validateAllLinesPerpendicular(points);
    }

    private void validateNumberOfPoints(List<Point> points) {
        long numOfDistinctPoints = points.stream()
                .distinct()
                .count();

        if (numOfDistinctPoints != NUM_OF_POINTS) {
            throw new IllegalArgumentException(
                    String.format("Rectangle 은 %d 개의 서로 다른 점으로 이루어져야 합니다.", NUM_OF_POINTS));
        }
    }

    private void validateAllLinesPerpendicular(List<Point> points) {
        List<Vector> vectors = new ArrayList<>(Arrays.asList(
                Vector.of(points.get(0), points.get(1)),
                Vector.of(points.get(1), points.get(2)),
                Vector.of(points.get(2), points.get(3)),
                Vector.of(points.get(3), points.get(0))
        ));

        for (int i = 0; i < vectors.size() - 1; i++) {
            Vector v1 = vectors.get(i);
            Vector v2 = vectors.get(i + 1);
            if (!v1.isPerpendicular(v2)) {
                throw new IllegalArgumentException("직사각형은 네 각이 모두 수직이어야 합니다.");
            }
        }
    }

    public static Rectangle of(List<Point> points) {
        return new Rectangle(points);
    }

    @Override
    public FigureType getType() {
        return FigureType.RECTANGLE;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public double calculate() {
        return points.get(0).distance(points.get(1)) * points.get(1).distance(points.get(2));
    }
}
