package coordinate.console;

import coordinate.console.view.InputView;
import coordinate.console.view.OutputView;
import coordinate.domain.Figure;
import coordinate.domain.FigureFactory;
import coordinate.domain.PointGroup;
import coordinate.domain.PointGroupFactory;

public class ConsoleApp {

    private final InputView inputView;
    private final OutputView outputView;
    private final PointGroupFactory pointGroupFactory;

    public ConsoleApp() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.pointGroupFactory = new PointGroupFactory();
    }

    public void run() {
        final PointGroup pointGroup = createPointGroup();
        final Figure figure = FigureFactory.create(pointGroup);

        outputView.printCoordinates(figure);
        outputView.printArea(figure);
    }

    private PointGroup createPointGroup() {
        try {
            final String inputPoints = inputView.inputPoints();
            return pointGroupFactory.create(inputPoints);
        } catch (Exception e) {
            outputView.printException(e.getMessage());
            return createPointGroup();
        }
    }

}
