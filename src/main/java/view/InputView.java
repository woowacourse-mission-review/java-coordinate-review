package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner READER = new Scanner(System.in);

    public static String askUserInput(String message) {
        System.out.println(message);
        return READER.nextLine();
    }
}
