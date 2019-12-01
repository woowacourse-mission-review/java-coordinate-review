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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RectangleCreatorTest {

    private final RectangleCreator creator = new RectangleCreator();

    @Test
    @DisplayName("다른 네 점 사각형 생성 가능한지")
    void create_rectangle() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        assertTrue(creator.canCreate(points));
    }

    @Test
    @DisplayName("4개 미만의 점인 경우 사각형 생성 불가능한지")
    void create_rectangle_with_under_4_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        assertFalse(creator.canCreate(points));
    }

    @Test
    @DisplayName("4개 초과의 점을 입력할 경우 사각형 생성 불가능한지")
    void create_rectangle_with_over_4_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point5 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4, point5);

        assertFalse(creator.canCreate(points));
    }

    @Test
    @DisplayName("같은 점을 포함한 4개 점을 입력할 경우 사각형 생성 불가능한지")
    void create_rectangle_with_same_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        assertFalse(creator.canCreate(points));
    }

    @Test
    @DisplayName("기울어진 사각형을 입력할 경우 사각형 생성 불가능한지")
    void create_rectangle_with_diamond_points() {
        Point point1 = Point.of(2, 1);
        Point point2 = Point.of(1, 2);
        Point point3 = Point.of(2, 3);
        Point point4 = Point.of(3, 2);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        assertFalse(creator.canCreate(points));
    }
}