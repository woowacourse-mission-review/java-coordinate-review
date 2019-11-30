package coordinate.console.view;

import coordinate.domain.figure.Figure;
import coordinate.domain.point.Coordinate;
import coordinate.domain.point.PointGroup;

public class OutputView {
    private static final String POLE_HEIGHT = "|";
    private static final String NEW_LINE = "\n";

    public void printArea(final Figure figure) {
        System.out.println(String.format("%s의 넓이는 %.2f", figure.getName(), figure.area()));
    }

    public void printGraph(final PointGroup pointGroup) {
        final Graph graph = new Graph(pointGroup);
        final boolean[][] coordinates = graph.getCoordinates();

        StringBuilder sb = new StringBuilder();
        for (int i = coordinates.length - 1; i >= 0; i--) {
            sb.append(String.format("%2d|", i));
            for (int j = 0; j < coordinates.length; j++) {
                sb.append(coordinates[j][i] ? "*  " : "   ");
            }
            sb.append(NEW_LINE);
        }

        sb.append("------------------------------------------------------------------------------");
        sb.append(NEW_LINE);
        for (int i = 0; i <= Coordinate.MAX_VALUE; i += 2) {
            sb.append(String.format("%6d", i));
        }
        System.out.println(sb.toString());
    }

    public void printException(final String message) {
        System.err.println(message);
    }
}
