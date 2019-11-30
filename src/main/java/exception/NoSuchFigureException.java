package exception;

public class NoSuchFigureException extends RuntimeException {
    private static final String MESSAGE = "그런 포인트로는 아무것도 만들 수 없습니다.";

    public NoSuchFigureException() {
        super(MESSAGE);
    }
}
