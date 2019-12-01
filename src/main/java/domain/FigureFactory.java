package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FigureFactory {
    private static final Map<Integer, FigureCreator> FIGURE_CREATOR_MAPPINGS = new HashMap<>();

    static {
        FIGURE_CREATOR_MAPPINGS.put(2, Line::of);
        FIGURE_CREATOR_MAPPINGS.put(3, Triangle::of);
        FIGURE_CREATOR_MAPPINGS.put(4, Rectangle::of);
    }

    public static Figure of(List<Point> points) {
        points = points.stream()
                .distinct()
                .collect(Collectors.toList());
        FigureCreator creator = FIGURE_CREATOR_MAPPINGS.get(points.size());
        return creator.create(points);
    }
}
