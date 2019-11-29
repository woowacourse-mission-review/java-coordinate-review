package coordinates.domain.figure;

import coordinates.domain.point.Points;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {

    private static final Map<Integer, Function<Points, Figure>> FIGURE_CREATORS = new HashMap<>();

    static {
        FIGURE_CREATORS.put(Line.SIZE_OF_POINTS_IN_LINE, Line::from);
        FIGURE_CREATORS.put(Triangle.SIZE_OF_POINTS_IN_TRIANGLE, Triangle::from);
        FIGURE_CREATORS.put(Rectangle.SIZE_OF_POINTS_IN_RECTANGLE, Rectangle::from);
    }

    private FigureFactory() {
    }

    public static FigureFactory getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final FigureFactory INSTANCE = new FigureFactory();
    }

    public Figure create(final Points points) {
        Function<Points, Figure> figureCreator = FIGURE_CREATORS.get(points.size());
        return figureCreator.apply(points);
    }
}
