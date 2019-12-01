package coordinatecalculator.domain.figure;

import coordinatecalculator.domain.result.Result;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Figure {

    private final List<AttributeCreator> creators;
    protected final List<Point> points;

    public Figure(final List<Point> points, final List<AttributeCreator> creators) {
        this.points = points;
        this.creators = creators;
    }

    public abstract boolean contains(Point point);

    public Result createResult() {
        List<String> attributesMessages = creators.stream()
                .map(attributeCreator -> attributeCreator.create(points))
                .collect(Collectors.toList());

        return Result.of(points, attributesMessages);
    }
}
