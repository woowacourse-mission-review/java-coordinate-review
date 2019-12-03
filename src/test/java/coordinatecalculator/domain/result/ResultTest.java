package coordinatecalculator.domain.result;

import coordinatecalculator.domain.figure.Point;
import coordinatecalculator.domain.figure.line.Line;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MAX_Y_COORDINATE;
import static coordinatecalculator.domain.figure.line.LineLengthAttributeCreator.LINE_LENGTH_ATTRIBUTES_MESSAGE_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResultTest {

    @Test
    @DisplayName("직선 결과")
    void line_result() {
        Point point1 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);
        Line line = Line.of(points);

        Result result = line.createResult();
        assertTrue(result.contains(point1));
        assertTrue(result.contains(point2));
        double length = MAX_X_COORDINATE - MIN_X_COORDINATE;
        assertEquals(result.getAttributeMessages().get(0), String.format(LINE_LENGTH_ATTRIBUTES_MESSAGE_FORMAT, length));
    }
}