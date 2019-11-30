package domain.figure;

import domain.Points;
import exception.NoSuchFigureException;
import exception.RectangleException;

import java.util.Arrays;
import java.util.function.Function;

public enum FigureFactory {
    LINE(2, Line::new),
    TRIANGLE(3, Triangle::new),
    RECTANGLE(4, Rectangle::new);

    private int numberOfPoints;
    private Function<Points, Figure> creatingFunction;

    FigureFactory(int numberOfPoints, Function<Points, Figure> creatingFunction) {
        this.numberOfPoints = numberOfPoints;
        this.creatingFunction = creatingFunction;
    }

    public static Figure createFigure(Points points) {
        Function<Points, Figure> creatingFunction = Arrays.stream(values())
                .filter(value -> points.isRightKey(value.numberOfPoints))
                .findAny()
                .orElseThrow(NoSuchFigureException::new)
                .creatingFunction;

        try {
            return creatingFunction.apply(points);
        } catch (RectangleException e) {
            System.out.println(e.getMessage());
            throw new RectangleException();
        }
    }
}
