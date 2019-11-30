package exception;

public class UnavailabeCoordinateException extends RuntimeException {
    public static final String MESSAGE = "점의 좌표은 0~25까지만 허용합니다";

    public UnavailabeCoordinateException() {
        super(MESSAGE);
    }
}
