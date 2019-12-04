package coordinates;

import coordinates.controller.CoordinateCalculatorController;
import coordinates.view.ConsoleInputView;
import coordinates.view.ConsoleOutputView;
import coordinates.view.InputView;
import coordinates.view.OutputView;

public class CoordinateCalculator {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        new CoordinateCalculatorController(inputView, outputView).run();
    }
}
