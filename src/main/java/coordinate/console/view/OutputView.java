package coordinate.console.view;

import coordinate.domain.Figure;

public class OutputView {
    public void printArea(final Figure figure) {
        System.out.println(String.format("%s의 넓이는 %.2f", figure.getName(), figure.area()));
    }

    public void printCoordinates(final Figure figure) {

    }

    public void printException(final String message) {
        System.err.println(message);
    }
}
