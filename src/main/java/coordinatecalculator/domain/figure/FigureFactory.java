package coordinatecalculator.domain.figure;

import com.google.common.collect.Lists;
import coordinatecalculator.domain.figure.line.LineCreator;
import coordinatecalculator.domain.figure.rectangle.RectangleCreator;
import coordinatecalculator.domain.figure.triangle.TriangleCreator;

import java.util.List;

public class FigureFactory {

    private final List<FigureCreator> figureCreator = Lists.newArrayList(new LineCreator()
            , new TriangleCreator(), new RectangleCreator());

    public Figure createFigure(List<Point> points) {
        return figureCreator.stream()
                .filter(creator -> creator.canCreate(points))
                .map(creator -> creator.create(points))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
