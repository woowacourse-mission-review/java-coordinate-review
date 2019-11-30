package exception;

public class DuplicatePointsException extends RuntimeException {
    private static final String MESSAGE = "중복된 포인트가 있습니다!";

    public DuplicatePointsException() {
        super(MESSAGE);
    }
}
