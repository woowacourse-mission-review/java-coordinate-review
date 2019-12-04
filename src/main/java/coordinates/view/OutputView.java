package coordinates.view;

import coordinates.domain.figure.Figure;
import coordinates.domain.point.Points;

public interface OutputView {
    void showExceptionMessage(Exception e);

    void showCoordinatesWith(Points points);

    void showAreaOfFigure(Figure figure);
}
