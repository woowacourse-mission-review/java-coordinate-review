public class InvalidNumberOfPointsException extends RuntimeException {
    private static final String MESSAGE = "알맞은 좌표의 개수가 아닙니다.(직선: 2개, 삼각형: 3개, 사각형: 4개)";

    public InvalidNumberOfPointsException() {
        super(MESSAGE);
    }
}
