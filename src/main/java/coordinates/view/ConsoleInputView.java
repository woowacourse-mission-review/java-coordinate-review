package coordinates.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputPoints() {
        return inputWithMessage("좌표를 입력하세요.");
    }

    private String inputWithMessage(final String inputMessage) {
        System.out.println(inputMessage);
        return scanner.nextLine();
    }
}
