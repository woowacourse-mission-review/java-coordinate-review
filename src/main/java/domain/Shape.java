package domain;

import domain.exception.DuplicatePointException;

import java.util.HashSet;
import java.util.List;

public abstract class Shape {
    protected final List<Point> points;

    public Shape(List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(List<Point> points) {
        if (points.size() != new HashSet<>(points).size()) {
            throw new DuplicatePointException();
        }
    }

    public abstract Double area();
}
