package coordinates.exception;

import coordinates.domain.point.unitcoordinate.XCoordinate;

public class OutOfXCoordinateBoundException extends IllegalArgumentException {

    public static final String OUT_OF_X_COORDINATE_BOUND_MESSAGE
            = "x좌표의 범위는 " + XCoordinate.LOWER_BOUND + " ~ " + XCoordinate.UPPER_BOUND + " 입니다.";

    public OutOfXCoordinateBoundException() {
        super(OUT_OF_X_COORDINATE_BOUND_MESSAGE);
    }
}
