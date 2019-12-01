package coordinatecalculator.domain.figure.line;

import coordinatecalculator.domain.figure.AttributeCreator;
import coordinatecalculator.domain.figure.Point;

import java.util.List;

public class LineLengthAttributeCreator implements AttributeCreator {

    public static final String LINE_LENGTH_ATTRIBUTES_MESSAGE_FORMAT = "두 점 사이의 거리는 %.2f 입니다.";

    @Override
    public String create(final List<Point> points) {
        Point startPoint = points.get(0);
        Point endPoint = points.get(1);

        return String.format(LINE_LENGTH_ATTRIBUTES_MESSAGE_FORMAT, startPoint.calculateDistance(endPoint));
    }
}
