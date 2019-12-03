package coordinatecalculator.domain.figure;

import java.util.List;

public interface FigureCreator<T extends Figure> {

    boolean canCreate(List<Point> points);

    T create(List<Point> points);
}
