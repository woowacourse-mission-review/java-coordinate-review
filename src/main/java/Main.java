import domain.Point;
import domain.Shape;
import domain.ShapeFactory;
import util.ConsolePointsGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Shape shape = createShape(inputView);
        OutputView.printResult(shape);
    }

    private static Shape createShape(InputView inputView) {
        try {
            List<Point> points = ConsolePointsGenerator.generate(inputView.inputPoints());
            return ShapeFactory.create(points);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createShape(inputView);
        }    }

}
