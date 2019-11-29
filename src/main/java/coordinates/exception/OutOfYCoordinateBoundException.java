package coordinates.exception;

import coordinates.domain.point.unitcoordinate.YCoordinate;

public class OutOfYCoordinateBoundException extends IllegalArgumentException {

    public static final String OUT_OF_Y_COORDINATE_BOUND_MESSAGE
            = "y좌표의 범위는 " + YCoordinate.LOWER_BOUND + " ~ " + YCoordinate.UPPER_BOUND + " 입니다.";

    public OutOfYCoordinateBoundException() {
        super(OUT_OF_Y_COORDINATE_BOUND_MESSAGE);
    }
}
