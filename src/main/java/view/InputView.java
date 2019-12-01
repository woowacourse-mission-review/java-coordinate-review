package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_POINTS_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)((-)\\(([0-9]+)(,)([0-9]+)\\))*";

    private Scanner scanner = new Scanner(System.in);

    public List<String> inputPoints() {
        System.out.println("좌표를 입력하세요.");
        String inputs = scanner.nextLine();
        checkValidForm(inputs);
        return Arrays.asList(inputs.split("-"));
    }

    private void checkValidForm(String text) {
        if (!text.matches(INPUT_POINTS_REGEX)) {
            throw new IllegalArgumentException("정상적인 좌표 형식이 아닙니다.");
        }
    }
}
