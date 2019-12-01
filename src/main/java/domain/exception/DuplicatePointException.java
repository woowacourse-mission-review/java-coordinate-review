package domain.exception;

public class DuplicatePointException extends RuntimeException {
    private static final String MESSAGE = "중복된 점이 존재합니다.";

    public DuplicatePointException() {
        super(MESSAGE);
    }
}
