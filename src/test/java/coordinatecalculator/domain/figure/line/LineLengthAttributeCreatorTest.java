package coordinatecalculator.domain.figure.line;

import com.google.common.collect.Lists;
import coordinatecalculator.domain.figure.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MAX_Y_COORDINATE;
import static coordinatecalculator.domain.figure.line.LineLengthAttributeCreator.LINE_LENGTH_ATTRIBUTES_MESSAGE_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LineLengthAttributeCreatorTest {

    private LineLengthAttributeCreator creator = new LineLengthAttributeCreator();

    @Test
    @DisplayName("직선 거리 메시지 추가")
    void create_line_length_message() {
        Point point1 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        Double difference = (double) (MAX_X_COORDINATE - MIN_X_COORDINATE);
        assertEquals(creator.create(points), String.format(LINE_LENGTH_ATTRIBUTES_MESSAGE_FORMAT, difference));
    }
}