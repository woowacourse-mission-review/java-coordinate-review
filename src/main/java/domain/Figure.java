package domain;

import java.util.List;

public interface Figure {
    FigureType getType();
    List<Point> getPoints();
    double calculate();
}
