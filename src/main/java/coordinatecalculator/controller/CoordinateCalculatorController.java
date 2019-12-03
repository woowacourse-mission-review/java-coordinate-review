package coordinatecalculator.controller;

import coordinatecalculator.domain.InvalidInputFormatException;
import coordinatecalculator.domain.coordinates.exception.InvalidCoordinateException;
import coordinatecalculator.domain.figure.exception.InvalidFigureCreationException;
import coordinatecalculator.domain.result.Result;
import coordinatecalculator.service.CoordinateCalculatorService;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;

public class CoordinateCalculatorController {

    private static final int INITIAL_REPEAT_COUNT = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private final CoordinateCalculatorService calculatorService = new CoordinateCalculatorService();

    public CoordinateCalculatorController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Result result = inputPoints(INITIAL_REPEAT_COUNT);
        outputView.printResult(result);
    }

    private Result inputPoints(final int repeatCount) {
        try {
            return calculatorService.calculate(inputView.inputPoints(repeatCount));
        } catch (InvalidInputFormatException | InvalidFigureCreationException | InvalidCoordinateException e) {
            outputView.printErrorMessage(e);
            return inputPoints(repeatCount + 1);
        }
    }
}
