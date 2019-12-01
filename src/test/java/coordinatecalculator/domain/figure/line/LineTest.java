package coordinatecalculator.domain.figure.line;

import com.google.common.collect.Lists;
import coordinatecalculator.domain.figure.Point;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MAX_Y_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MIN_Y_COORDINATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("Line 생성")
    void generate_line() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        assertDoesNotThrow(() -> Line.of(points));
    }

    @Test
    @DisplayName("같은 점 두개를 입력했을 때 에러 발생")
    void generate_line_same_point() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        assertThrows(IllegalArgumentException.class, () -> Line.of(points));
    }

    @Test
    @DisplayName("점이 두개가 아닐 때 에러 발생")
    void generate_line_not_two_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> onePoint = Lists.newArrayList(point1);
        List<Point> threePoints = Lists.newArrayList(point1, point2, point3);

        assertThrows(IllegalArgumentException.class, () -> Line.of(onePoint));
        assertThrows(IllegalArgumentException.class, () -> Line.of(threePoints));
    }

    @Test
    @DisplayName("점이 직선의 양 점에 포함될 경우 contains 메서드 true 리턴")
    void contains_point() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        Line line = Line.of(points);
        assertTrue(line.contains(point1));
    }

    @Test
    @DisplayName("점이 직선의 양 점에 포함되지 않을 경우 contains 메서드 false 리턴")
    void not_contains_point() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        Point point3 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        Line line = Line.of(points);
        assertFalse(line.contains(point3));
    }

    @Test
    @DisplayName("직선의 양 점이 같을 경우 같은 객체인지")
    void equals_lines_with_same_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        Line line1 = Line.of(points);
        Line line2 = Line.of(points);

        assertEquals(line1, line2);
    }

    @Test
    @DisplayName("양 끝 점이 같은 직선들을 HashSet에 넣을 경우 중복으로 인식하는지")
    void equal_lines_in_hashset_size_1() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        Line line1 = Line.of(points);
        Line line2 = Line.of(points);

        Set<Line> lines = Sets.newHashSet(Lists.newArrayList(line1, line2));
        assertThat(lines.size()).isEqualTo(1);
    }
}