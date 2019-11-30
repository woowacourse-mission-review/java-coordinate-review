import domain.Graph;
import domain.Points;
import domain.figure.Figure;
import domain.figure.FigureFactory;
import exception.DuplicatePointsException;
import exception.UnavailabeCoordinateException;
import view.InputView;
import view.OutputView;

public class CoordinateGame {
    private InputView inputView;
    private OutputView outputView;

    public CoordinateGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Points points = registerPoints();
        Figure figure = FigureFactory.createFigure(points);
        Graph graph  = figure.drawGraph();
    }

    private Points registerPoints() {
        try {
            String userInput = InputView.askUserInput("좌표를 입력해 주세요!");
            return new Points(userInput);
        } catch(DuplicatePointsException | UnavailabeCoordinateException e) {
            outputView.printErrorMessage(e.getMessage());
            return registerPoints();
        }
    }
}
