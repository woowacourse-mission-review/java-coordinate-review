package coordinates.view;

import coordinates.domain.point.Points;

public interface OutputView {
    void showExceptionMessage(Exception e);

    void showCoordinatesWith(Points points);
}
