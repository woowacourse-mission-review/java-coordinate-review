package coordinate.domain;

import java.util.function.Function;
import java.util.stream.Stream;

public enum FigureFactory {
    LINE(Line.SIZE_OF_POINTS, Line::new),
    TRIANGLE(Line.SIZE_OF_POINTS, Line::new),
    RECTANGLE(Line.SIZE_OF_POINTS, Line::new);

    private final int sizeOfPointGroup;
    private final Function<PointGroup, Figure> figureGenerator;

    FigureFactory(final int sizeOfPointGroup, final Function<PointGroup, Figure> figureGenerator) {
        this.sizeOfPointGroup = sizeOfPointGroup;
        this.figureGenerator = figureGenerator;
    }

    public static Figure create(final PointGroup pointGroup) {
        return Stream.of(values())
                .filter(x -> pointGroup.matchSize(x.sizeOfPointGroup))
                .findFirst()
                .map(x -> x.figureGenerator.apply(pointGroup))
                .orElseThrow(UnsupportedOperationException::new)
                ;
    }
}
