package coordinates.controller;

import coordinates.domain.Points;
import coordinates.service.CoordinateCalculatorService;
import coordinates.view.InputView;
import coordinates.view.OutputView;

public class CoordinateCalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CoordinateCalculatorService service = new CoordinateCalculatorService();

    public CoordinateCalculatorController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        boolean isValidInput = true;
        while (isValidInput) {
            isValidInput = calculateWithPoints();
        }
    }

    private boolean calculateWithPoints() {
        try {
            String pointInputs = inputView.inputPoints();
            Points points = service.parsePointInputs(pointInputs);
            return false;
        } catch (IllegalArgumentException e) {
            outputView.showExceptionMessage(e);
            return true;
        }
    }
}
