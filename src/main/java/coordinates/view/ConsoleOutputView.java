package coordinates.view;

import coordinates.domain.figure.Figure;
import coordinates.domain.figure.Line;
import coordinates.domain.figure.Rectangle;
import coordinates.domain.figure.Triangle;
import coordinates.domain.point.Points;
import coordinates.domain.point.unitcoordinate.XCoordinate;
import coordinates.domain.point.unitcoordinate.YCoordinate;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ConsoleOutputView implements OutputView {

    private static final String EXCEPTION_MESSAGE_PREFIX = "ERROR : ";
    private static final int ORIGIN = 0;
    private static final int UNIT_SIZE_OF_X_AXIS = 3;
    private static final int UNIT_SIZE_OF_Y_AXIS = 2;
    private static final String UNIT_CHAR_OF_X_AXIS = "-";
    private static final String UNIT_CHAR_OF_Y_AXIS = "|";
    private static final String CHAR_OF_POINT = "*";
    private static final String CHAR_OF_ORIGIN = "+";
    private static final String EMPTY = "";

    private static final Map<Integer, String> MESSAGES_OF_SHOWING_FIGURE_AREA = new HashMap<>();

    static {
        MESSAGES_OF_SHOWING_FIGURE_AREA.put(Line.SIZE_OF_POINTS_IN_LINE, "두 점 사이 거리는 ");
        MESSAGES_OF_SHOWING_FIGURE_AREA.put(Triangle.SIZE_OF_POINTS_IN_TRIANGLE, "삼각형의 넓이는 ");
        MESSAGES_OF_SHOWING_FIGURE_AREA.put(Rectangle.SIZE_OF_POINTS_IN_RECTANGLE, "사각형의 넓이는 ");
    }

    @Override
    public void showExceptionMessage(final Exception e) {
        System.out.println(EXCEPTION_MESSAGE_PREFIX + e.getMessage());
    }

    @Override
    public void showCoordinatesWith(final Points points) {
        for (int y = YCoordinate.UPPER_BOUND; y >= YCoordinate.LOWER_BOUND; y--) {
            System.out.println(generateLine(points, y));
        }
        System.out.println(generateXAxis());
        System.out.println(generateXAxisNumbers());
    }

    private String generateLine(final Points points, final int y) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateYAxisWithNumbers(y));

        for (int x = XCoordinate.LOWER_BOUND; x <= XCoordinate.UPPER_BOUND; x++) {
            stringBuilder.append(generateHorizontalAreaWithPoint(points, x, y));
        }
        return stringBuilder.toString();
    }

    private String generateYAxisWithNumbers(final int y) {
        return generateUnitPieceWithEvenNumber(y, UNIT_SIZE_OF_Y_AXIS) + UNIT_CHAR_OF_Y_AXIS;
    }

    private String generateHorizontalAreaWithPoint(final Points points, final int x, final int y) {
        return points.contains(x, y) ? leftPad(CHAR_OF_POINT, UNIT_SIZE_OF_X_AXIS) : leftPad(EMPTY, UNIT_SIZE_OF_X_AXIS);
    }

    private String generateXAxis() {
        return leftPad(CHAR_OF_ORIGIN, UNIT_SIZE_OF_X_AXIS) + StringUtils.repeat(UNIT_CHAR_OF_X_AXIS, XCoordinate.UPPER_BOUND * UNIT_SIZE_OF_X_AXIS);
    }

    private String generateXAxisNumbers() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = ORIGIN; x <= XCoordinate.UPPER_BOUND; x++) {
            stringBuilder.append(generateUnitPieceWithEvenNumber(x, UNIT_SIZE_OF_X_AXIS));
        }
        return stringBuilder.toString();
    }

    private String generateUnitPieceWithEvenNumber(final int index, final int sizeOfLeftPad) {
        String str = (index % 2 == 0) ? String.valueOf(index) : EMPTY;
        return leftPad(str, sizeOfLeftPad);
    }

    private String leftPad(final String str, final int size) {
        return StringUtils.leftPad(str, size);
    }

    @Override
    public void showAreaOfFigure(final Figure figure) {
        String message = MESSAGES_OF_SHOWING_FIGURE_AREA.get(figure.size());

        DecimalFormat df = new DecimalFormat("0.######");
        System.out.println(message + df.format(figure.area()));
    }
}
