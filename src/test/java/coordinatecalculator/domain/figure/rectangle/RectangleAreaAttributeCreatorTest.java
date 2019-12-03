package coordinatecalculator.domain.figure.rectangle;

import com.google.common.collect.Lists;
import coordinatecalculator.domain.figure.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MAX_Y_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MIN_Y_COORDINATE;
import static coordinatecalculator.domain.figure.rectangle.RectangleAreaAttributeCreator.RECTANGLE_AREA_ATTRIBUTES_MESSAGE_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleAreaAttributeCreatorTest {

    private RectangleAreaAttributeCreator creator = new RectangleAreaAttributeCreator();

    @Test
    @DisplayName("사각형 넓이 메시지 생성")
    void create_rectangle_area_message() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        double area = point1.calculateDistance(point2) * point1.calculateDistance(point3);
        assertEquals(creator.create(points), String.format(RECTANGLE_AREA_ATTRIBUTES_MESSAGE_FORMAT, area));
    }
}