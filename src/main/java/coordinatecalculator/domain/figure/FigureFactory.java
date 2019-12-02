package coordinatecalculator.domain.figure;

import com.google.common.collect.Lists;
import coordinatecalculator.domain.figure.exception.InvalidFigureCreationException;
import coordinatecalculator.domain.figure.line.LineCreator;
import coordinatecalculator.domain.figure.rectangle.RectangleCreator;
import coordinatecalculator.domain.figure.triangle.TriangleCreator;

import java.util.List;

public class FigureFactory {

    public static final String INVALID_FIGURE_CREATION_EXCEPTION_MESSAGE = "입력한 점들을 가질 수 있는 도형이 없습니다.";

    private final List<FigureCreator> figureCreator = Lists.newArrayList(new LineCreator()
            , new TriangleCreator(), new RectangleCreator());

    public Figure createFigure(final List<Point> points) {
        return figureCreator.stream()
                .filter(creator -> creator.canCreate(points))
                .map(creator -> creator.create(points))
                .findAny()
                .orElseThrow(() -> new InvalidFigureCreationException(INVALID_FIGURE_CREATION_EXCEPTION_MESSAGE));
    }
}
