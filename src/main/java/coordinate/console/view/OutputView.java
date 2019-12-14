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
        drawPoints(coordinates, sb);
        sb.append("------------------------------------------------------------------------------");
        sb.append(NEW_LINE);
        drawXNumber(sb);
        System.out.println(sb.toString());
    }

    private void drawPoints(final boolean[][] coordinates, final StringBuilder sb) {
        for (int i = coordinates.length - 1; i >= 0; i--) {
            sb.append(String.format("%2d%s", i, POLE_HEIGHT));
            drawWidth(coordinates, sb, i);
            sb.append(NEW_LINE);
        }
    }

    private void drawWidth(final boolean[][] coordinates, final StringBuilder sb, final int i) {
        for (int j = 0; j < coordinates.length; j++) {
            sb.append(coordinates[j][i] ? "*  " : "   ");
        }
    }

    private void drawXNumber(final StringBuilder sb) {
        for (int i = 0; i <= Coordinate.MAX_VALUE; i += 2) {
            sb.append(String.format("%6d", i));
        }
    }

    public void printException(final Exception exception) {
        System.err.println(exception.getMessage());
    }
}
