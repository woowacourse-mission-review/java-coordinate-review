import view.InputView;
import view.OutputView;

public class GameLauncher {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CoordinateGame coordinateGame = new CoordinateGame(inputView, outputView);
        coordinateGame.start();
    }
}
