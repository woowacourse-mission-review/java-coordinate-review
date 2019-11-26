package coordinates.exception;

public class IllegalPointsException extends IllegalArgumentException {

    public static final String ILLEGAL_POINTS_MESSAGE = "올바르지 않은 좌표 형식입니다.";

    public IllegalPointsException() {
        super(ILLEGAL_POINTS_MESSAGE);
    }
}
