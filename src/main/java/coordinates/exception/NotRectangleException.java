package coordinates.exception;

public class NotRectangleException extends IllegalArgumentException {

    public static final String NOT_RECTANGLE_MESSAGE = "사각형은 좌표축에 변이 평행한 직사각형만 가능합니다.";

    public NotRectangleException() {
        super(NOT_RECTANGLE_MESSAGE);
    }
}
