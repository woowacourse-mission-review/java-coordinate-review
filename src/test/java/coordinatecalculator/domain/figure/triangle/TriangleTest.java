package coordinatecalculator.domain.figure.triangle;

import com.google.common.collect.Lists;
import coordinatecalculator.domain.figure.Point;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MAX_Y_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MIN_Y_COORDINATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    @DisplayName("삼각형 생성")
    void generate_triangle() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        assertDoesNotThrow(() -> Triangle.of(points));
    }

    @Test
    @DisplayName("3개 미만 점들로 삼각형 생성 에러")
    void generate_triangle_under_three_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> twoPoints = Lists.newArrayList(point1, point2);

        assertThrows(IllegalArgumentException.class, () -> Triangle.of(twoPoints));
    }

    @Test
    @DisplayName("3개 초과하는 점들로 삼각형 생성 에러")
    void generate_triangle_over_three_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        List<Point> fourPoints = Lists.newArrayList(point1, point2, point3, point4);

        assertThrows(IllegalArgumentException.class, () -> Triangle.of(fourPoints));
    }

    @Test
    @DisplayName("같은 점을 포함하는 세 점을 입력하는 경우 삼각형 생성 에러")
    void generate_triangle_with_same_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point2);

        assertThrows(IllegalArgumentException.class, () -> Triangle.of(points));
    }

    @Test
    @DisplayName("같은 기울기의 점들을 입력하는 경우 (한 직선에 세 점이 있는 경우) 삼각형 생성 에러")
    void generate_triangle_with_same_slopes() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MIN_X_COORDINATE + 1, MIN_Y_COORDINATE + 1);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        assertThrows(IllegalArgumentException.class, () -> Triangle.of(points));
    }

    @Test
    @DisplayName("점을 포함하는지 테스트")
    void contains_point() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        Triangle triangle = assertDoesNotThrow(() -> Triangle.of(points));
        assertTrue(triangle.contains(point1));
        assertTrue(triangle.contains(point2));
        assertTrue(triangle.contains(point3));
    }

    @Test
    @DisplayName("같은 점들로 구성된 삼각형들이 같은 객체인지")
    void equals() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        Triangle triangle1 = assertDoesNotThrow(() -> Triangle.of(points));
        Triangle triangle2 = assertDoesNotThrow(() -> Triangle.of(points));
        assertEquals(triangle1, triangle2);
    }

    @Test
    @DisplayName("같은 꼭지점의 삼각형들을 HashSet에 넣을 경우 중복으로 인식하는지")
    void equal_triangles_in_hashset_size_1() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        Triangle triangle1 = assertDoesNotThrow(() -> Triangle.of(points));
        Triangle triangle2 = assertDoesNotThrow(() -> Triangle.of(points));
        assertThat(Sets.newHashSet(Lists.newArrayList(triangle1, triangle2)).size()).isEqualTo(1);
    }
}