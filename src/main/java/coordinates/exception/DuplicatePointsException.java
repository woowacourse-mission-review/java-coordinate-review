package coordinates.exception;

public class DuplicatePointsException extends IllegalArgumentException {

    public static final String DUPLICATE_POINTS_MESSAGE = "중복된 점이 존재합니다.";

    public DuplicatePointsException() {
        super(DUPLICATE_POINTS_MESSAGE);
    }
}
