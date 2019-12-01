package coordinatecalculator.domain.figure.rectangle;

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

class RectangleTest {

    @Test
    @DisplayName("사각형 생성")
    void create_rectangle() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        assertDoesNotThrow(() -> new Rectangle(points));
    }

    @Test
    @DisplayName("4개 미만의 점을 입력할 경우 에러")
    void create_rectangle_with_under_4_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3);

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }

    @Test
    @DisplayName("4개 초과의 점을 입력할 경우 에러")
    void create_rectangle_with_over_4_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        Point point5 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4, point5);

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }

    @Test
    @DisplayName("같은 점을 포함한 4개 점을 입력할 경우 에러")
    void create_rectangle_with_same_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }

    @Test
    @DisplayName("기울어진 사각형을 입력할 경우 에러")
    void create_rectangle_with_diamond_points() {
        Point point1 = Point.of(2, 1);
        Point point2 = Point.of(1, 2);
        Point point3 = Point.of(2, 3);
        Point point4 = Point.of(3, 2);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }

    @Test
    @DisplayName("점을 포함하는지 테스트")
    void contains_point() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        Rectangle rectangle = assertDoesNotThrow(() -> new Rectangle(points));
        assertTrue(rectangle.contains(point1));
        assertTrue(rectangle.contains(point2));
        assertTrue(rectangle.contains(point3));
        assertTrue(rectangle.contains(point4));
    }

    @Test
    @DisplayName("사각형의 꼭지점이 같을 경우 같은 객체인지")
    void equals() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        Rectangle rectangle1 = assertDoesNotThrow(() -> new Rectangle(points));
        Rectangle rectangle2 = assertDoesNotThrow(() -> new Rectangle(points));
        assertEquals(rectangle1, rectangle2);
    }

    @Test
    @DisplayName("같은 꼭지점의 사각형들을 HashSet에 넣을 경우 중복으로 인식하는지")
    void hash() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE);
        Point point4 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2, point3, point4);

        Rectangle rectangle1 = assertDoesNotThrow(() -> new Rectangle(points));
        Rectangle rectangle2 = assertDoesNotThrow(() -> new Rectangle(points));
        assertThat(Sets.newHashSet(Lists.newArrayList(rectangle1, rectangle2)).size()).isEqualTo(1);
    }
}