package coordinatecalculator.domain.figure.triangle;

import com.google.common.collect.Lists;
import coordinatecalculator.domain.figure.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MAX_Y_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MIN_Y_COORDINATE;
import static coordinatecalculator.domain.figure.triangle.TriangleAreaAttributeCreator.TRIANGLE_AREA_ATTRIBUTES_MESSAGE_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleAreaAttributeCreatorTest {

    private final TriangleAreaAttributeCreator creator = new TriangleAreaAttributeCreator();

    @Test
    @DisplayName("삼각형 넓이 메시지 생성")
    void create_triangle_area_attribute_message() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        double area = Math.pow(MAX_X_COORDINATE - MIN_X_COORDINATE, 2) / 2;
        assertEquals(creator.create(points), String.format(TRIANGLE_AREA_ATTRIBUTES_MESSAGE_FORMAT, area));
    }
}