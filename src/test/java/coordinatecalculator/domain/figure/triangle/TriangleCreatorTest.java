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
import static org.junit.jupiter.api.Assertions.*;

class TriangleCreatorTest {

    private final TriangleCreator triangleCreator = new TriangleCreator();

    @Test
    @DisplayName("세 개의 한 직선 위에 있지 않은 점으로 삼각형을 만들 수 있는지")
    void generate_triangle() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        assertTrue(triangleCreator.canCreate(points));
    }

    @Test
    @DisplayName("3개 미만 점들로 삼각형 생성할 수 없는지")
    void generate_triangle_under_three_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        assertFalse(triangleCreator.canCreate(points));
    }

    @Test
    @DisplayName("3개 초과하는 점들로 삼각형 생성할 수 없는지")
    void generate_triangle_over_three_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        assertFalse(triangleCreator.canCreate(points));
    }

    @Test
    @DisplayName("같은 점을 포함하는 세 점을 입력하는 경우 삼각형을 생성할 수 없는지")
    void generate_triangle_with_same_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point2);

        assertFalse(triangleCreator.canCreate(points));
    }

    @Test
    @DisplayName("같은 기울기의 점들을 입력하는 경우 (한 직선에 세 점이 있는 경우) 삼각형을 생성할 수 없는지")
    void generate_triangle_with_same_slopes() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MIN_X_COORDINATE + 1, MIN_Y_COORDINATE + 1);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        assertFalse(triangleCreator.canCreate(points));
    }

    @Test
    @DisplayName("create 메소드를 통해 삼각형을 제대로 생성하는지")
    void create_triangle() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        assertEquals(triangleCreator.create(points), new Triangle(points));
    }
}