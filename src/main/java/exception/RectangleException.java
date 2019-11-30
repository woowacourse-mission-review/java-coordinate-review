package exception;

public class RectangleException extends RuntimeException {
    private static final String MESSAGE = "그런 점으로는 사각형을 만들 수 없습니다.";

    public RectangleException() {
        super(MESSAGE);
    }
}
