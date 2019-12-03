package coordinate.console;

import coordinate.console.view.InputView;
import coordinate.console.view.OutputView;
import coordinate.domain.figure.Figure;
import coordinate.domain.figure.FigureFactory;
import coordinate.domain.point.PointGroup;
import coordinate.domain.point.PointGroupFactory;

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

        outputView.printGraph(pointGroup);
        outputView.printArea(figure);
    }

    private PointGroup createPointGroup() {
        try {
            final String inputPoints = inputView.inputPoints();
            return pointGroupFactory.create(inputPoints);
        } catch (Exception e) {
            outputView.printException(e);
            return createPointGroup();
        }
    }

}
