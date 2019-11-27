package coordinates.view;

import coordinates.domain.Points;

public interface OutputView {
    void showExceptionMessage(Exception e);

    void showCoordinatesWith(Points points);
}
