package coordinate.console.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputPoints() {
        System.out.println("좌표를 입력하세요.");
        return scanner.nextLine();
    }
}
