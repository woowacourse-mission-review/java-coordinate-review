package coordinatecalculator.view;

import coordinatecalculator.view.exception.MaxRepeatCountExceedException;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private static final int MAX_REPEAT_COUNT = 5;

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputPoints(final int repeatCount) {
        if (repeatCount >= MAX_REPEAT_COUNT) {
            throw new MaxRepeatCountExceedException();
        }
        System.out.println("좌표를 입력하세요.");
        return scanner.nextLine();
    }
}
