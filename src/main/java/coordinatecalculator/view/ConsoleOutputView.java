package coordinatecalculator.view;

import coordinatecalculator.domain.figure.Point;
import coordinatecalculator.domain.result.Result;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MAX_Y_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MIN_Y_COORDINATE;

public class ConsoleOutputView implements OutputView {

    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String STRING_FORMAT = "%3s";
    private static final String POINT_TILE = "x";
    private static final String EMPTY_TILE = "";
    private static final String Y_AXIS = "|";
    private static final String X_AXIS = "---";
    private static final String CROSS_AXIS_POINT = "+";
    private static final String CROSS_AXIS_POINT_STRING_FORMAT = "%1s";

    @Override
    public void printErrorMessage(final Exception e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void printResult(final Result result) {
        StringBuilder sb = new StringBuilder();
        drawResult(result, sb);
        drawXAxis(sb);
        drawXAxisPoints(sb);
        printAttributesMessages(result, sb);
        System.out.println(sb.toString());
    }

    private void drawResult(final Result result, final StringBuilder sb) {
        sb.append(NEW_LINE);
        for (int yIndex = MAX_Y_COORDINATE; yIndex >= MIN_Y_COORDINATE; yIndex--) {
            drawYCoordinates(result, sb, yIndex);
        }
    }

    private void drawYCoordinates(final Result result, final StringBuilder sb, final int yIndex) {
        drawYAxis(sb, yIndex);
        for (int xIndex = MIN_X_COORDINATE; xIndex <= MAX_X_COORDINATE; xIndex++) {
            String tile = result.contains(Point.of(xIndex, yIndex)) ? POINT_TILE : EMPTY_TILE;
            sb.append(String.format(STRING_FORMAT, tile));
        }
        sb.append(NEW_LINE);
    }

    private void drawYAxis(final StringBuilder sb, final int yIndex) {
        sb.append(String.format(STRING_FORMAT, isEvenNumber(yIndex) ? String.valueOf(yIndex) : EMPTY_TILE))
                .append(Y_AXIS);
    }

    private void drawXAxis(final StringBuilder sb) {
        sb.append(String.format(CROSS_AXIS_POINT_STRING_FORMAT, EMPTY_TILE))
                .append(String.format(STRING_FORMAT, CROSS_AXIS_POINT));
        for (int xIndex = MIN_X_COORDINATE; xIndex <= MAX_X_COORDINATE; xIndex++) {
            sb.append(String.format(STRING_FORMAT, X_AXIS));
        }
        sb.append(NEW_LINE);
    }

    private void drawXAxisPoints(final StringBuilder sb) {
        sb.append(String.format(STRING_FORMAT, String.valueOf(0)));
        for (int xIndex = MIN_X_COORDINATE; xIndex <= MAX_X_COORDINATE; xIndex++) {
            sb.append(String.format(STRING_FORMAT, isEvenNumber(xIndex) ? String.valueOf(xIndex) : EMPTY_TILE));
        }
        sb.append(NEW_LINE);
    }

    private boolean isEvenNumber(final int target) {
        return target % 2 == 0;
    }

    private void printAttributesMessages(final Result result, final StringBuilder sb) {
        sb.append(NEW_LINE);
        for (String attributeMessage : result.getAttributeMessages()) {
            sb.append(attributeMessage);
        }
    }
}
