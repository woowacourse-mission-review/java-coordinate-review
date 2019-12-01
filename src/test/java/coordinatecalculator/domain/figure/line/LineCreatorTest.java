package coordinatecalculator.domain.figure.line;

import coordinatecalculator.domain.figure.Point;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MAX_Y_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MIN_Y_COORDINATE;
import static org.junit.jupiter.api.Assertions.*;

class LineCreatorTest {

    private final LineCreator lineCreator = new LineCreator();

    @Test
    @DisplayName("두 개의 다른 점으로 직을 만들 수 있는지")
    void can_create_two_different_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        assertTrue(lineCreator.canCreate(points));
    }

    @Test
    @DisplayName("두 개의 같은 점으로 직선을 만들 수 있는지")
    void can_create_same_point() {
        Point point = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point, point);

        assertFalse(lineCreator.canCreate(points));
    }

    @Test
    @DisplayName("두 개가 아닌 점으로 직선을 만들 수 있는지")
    void can_create_not_two_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> onePoint = Lists.newArrayList(point1);
        List<Point> threePoints = Lists.newArrayList(point1, point2, point3);

        assertFalse(lineCreator.canCreate(onePoint));
        assertFalse(lineCreator.canCreate(threePoints));
    }

    @Test
    @DisplayName("create 메소드 사용시 직선이 정상적으로 만들어 졌는지")
    void create_line() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        assertEquals(lineCreator.create(points), new Line(points));
    }
}