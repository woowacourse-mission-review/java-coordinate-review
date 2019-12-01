public class InvalidLineException extends RuntimeException {
    private static final String MESSAGE = "두 점은 서로 같을 수 없습니다.";

    public InvalidLineException() {
        super(MESSAGE);
    }
}
