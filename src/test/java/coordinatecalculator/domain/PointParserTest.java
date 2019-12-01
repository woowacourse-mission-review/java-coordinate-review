package coordinatecalculator.domain;

import coordinatecalculator.domain.figure.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointParserTest {

    private final PointParser pointParser = new PointParser();

    @Test
    @DisplayName("하나의 점을 입력했을 경우 parse")
    void parse_one_point() {
        String inputPoint = "(1,2)";

        List<Point> points = assertDoesNotThrow(() -> pointParser.parse(inputPoint));
        assertThat(points.size()).isEqualTo(1);
        assertTrue(points.contains(Point.of(1, 2)));
    }

    @Test
    @DisplayName("두개의 점을 입력했을 경우 parse")
    void parse_two_points() {
        String inputPoints = "(1,2)-(3,4)";

        List<Point> points = assertDoesNotThrow(() -> pointParser.parse(inputPoints));
        assertThat(points.size()).isEqualTo(2);
        assertTrue(points.contains(Point.of(1, 2)));
        assertTrue(points.contains(Point.of(3, 4)));
    }

    @Test
    @DisplayName("두개를 초과하는 점을 입력했을 경우 parse")
    void parse_over_two_points() {
        String inputPoints = "(1,2)-(3,4)-(5,6)";

        List<Point> points = assertDoesNotThrow(() -> pointParser.parse(inputPoints));
        assertThat(points.size()).isEqualTo(3);
        assertTrue(points.contains(Point.of(1, 2)));
        assertTrue(points.contains(Point.of(3, 4)));
        assertTrue(points.contains(Point.of(5, 6)));
    }

    @Test
    @DisplayName("잘못된 점들의 DELIMITER 사용 에러")
    void parse_wrong_point_delimiter_format() {
        String inputPoints = "(1,2)=(3,4)";

        assertThrows(IllegalArgumentException.class, () -> pointParser.parse(inputPoints));
    }

    @Test
    @DisplayName("잘못된 좌표들의 DELIMITER 사용 에러")
    void parse_wrong_coordinate_delimiter_format() {
        String inputPoints = "(1_2)-(3_4)";

        assertThrows(IllegalArgumentException.class, () -> pointParser.parse(inputPoints));
    }

    @Test
    @DisplayName("좌표 값에 문자를 입력한 경우 에러")
    void parse_not_integer_points_format() {
        String inputPoints = "(일,이)-(삼,사)";

        assertThrows(IllegalArgumentException.class, () -> pointParser.parse(inputPoints));
    }
}