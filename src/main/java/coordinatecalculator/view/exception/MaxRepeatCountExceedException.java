package coordinatecalculator.view.exception;

public class MaxRepeatCountExceedException extends RuntimeException {

    private static final String MAX_REPEAT_COUNT_EXCEED_EXCEPTION_MESSAGE = "최대 입력 실패 횟수를 입력했습니다.";

    public MaxRepeatCountExceedException() {
        super(MAX_REPEAT_COUNT_EXCEED_EXCEPTION_MESSAGE);
    }
}
