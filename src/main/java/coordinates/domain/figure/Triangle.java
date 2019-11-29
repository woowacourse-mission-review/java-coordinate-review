package coordinates.domain.figure;

import coordinates.domain.point.Point;
import coordinates.domain.point.Points;
import coordinates.exception.IllegalFigureCreationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Triangle implements Figure {

    public static final int SIZE_OF_POINTS_IN_TRIANGLE = 3;
    private static final int FIRST_INDEX_OF_POINTS = 0;
    private static final int HALF_DIVISOR = 2;

    private final Points points;

    private Triangle(final Points points) {
        if (points.size() != SIZE_OF_POINTS_IN_TRIANGLE) {
            throw new IllegalFigureCreationException();
        }

        this.points = points;
    }

    public static Triangle from(Points points) {
        return new Triangle(points);
    }

    @Override
    public int size() {
        return SIZE_OF_POINTS_IN_TRIANGLE;
    }

    /**
     * This calculation process is dependent on the Heron's formula
     * https://en.wikipedia.org/wiki/Heron%27s_formula
     */
    @Override
    public double area() {
        List<Double> distances = calculateDistances();
        double s = calculateHalfSumOfDistances(distances);
        return Math.sqrt(s * multiplyDeviationsWith(distances, s));
    }

    private List<Double> calculateDistances() {
        List<Double> distances = new ArrayList<>();

        IntStream.range(FIRST_INDEX_OF_POINTS, points.size()).forEach(index -> {
            double distance = calculateDistanceBetweenAdjacentPoints(index);
            distances.add(distance);
        });

        return distances;
    }

    private double calculateDistanceBetweenAdjacentPoints(final int index) {
        int nextIndex = isLastIndex(index) ? FIRST_INDEX_OF_POINTS : index + 1;

        Point point1 = points.get(index);
        Point point2 = points.get(nextIndex);
        return point1.calculateDistanceTo(point2);
    }

    private boolean isLastIndex(final int index) {
        return index == points.size() - 1;
    }

    private double calculateHalfSumOfDistances(final List<Double> distances) {
        Double sum = distances.stream()
                .reduce(Double::sum)
                .orElseThrow(RuntimeException::new);
        return sum / HALF_DIVISOR;
    }

    private double multiplyDeviationsWith(final List<Double> distances, final double s) {
        return distances.stream()
                .map(distance -> s - distance)
                .reduce((distance1, distance2) -> distance1 * distance2)
                .orElseThrow(RuntimeException::new);
    }
}
