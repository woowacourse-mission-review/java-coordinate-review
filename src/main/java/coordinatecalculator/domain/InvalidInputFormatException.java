package coordinatecalculator.domain;

public class InvalidInputFormatException extends RuntimeException {

    public static final String INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE
            = "좌표 입력 형식이 다릅니다. (1,2)-(1,4)-(5,6) 와 같은 형식으로 입력해주세요.";

    public InvalidInputFormatException() {
        super(INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE);
    }
}
