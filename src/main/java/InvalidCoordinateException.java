public class InvalidCoordinateException extends RuntimeException {
    private static final String MESSAGE = "유효하지 않는 좌표 값입니다.(좌표는 0이상 24이하의 정수입니다.)";

    public InvalidCoordinateException() {
        super(MESSAGE);
    }
}
