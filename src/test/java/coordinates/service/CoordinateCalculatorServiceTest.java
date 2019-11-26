package coordinates.service;

import coordinates.domain.Point;
import coordinates.domain.Points;
import coordinates.exception.IllegalPointsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateCalculatorServiceTest {

    private CoordinateCalculatorService service;

    @BeforeEach
    void setUp() {
        service = new CoordinateCalculatorService();
    }

    @Test
    void parsePointsInput() {
        Points points1 = service.parsePointsInput("(1, 2) - (3, 4)");
        Points points2 = service.parsePointsInput("(1, 2) - (3, 4)-(5, 6)");
        Points points3 = service.parsePointsInput("(1, 2) - (3, 4)-(5, 6)-(7, 8)");

        assertThat(points1.size()).isEqualTo(2);
        assertThat(points2.size()).isEqualTo(3);
        assertThat(points3.size()).isEqualTo(4);

        assertThat(points1.get(0)).isEqualTo(Point.of(1, 2));
        assertThat(points1.get(1)).isEqualTo(Point.of(3, 4));

        assertThat(points2.get(0)).isEqualTo(Point.of(1, 2));
        assertThat(points2.get(1)).isEqualTo(Point.of(3, 4));
        assertThat(points2.get(2)).isEqualTo(Point.of(5, 6));

        assertThat(points3.get(0)).isEqualTo(Point.of(1, 2));
        assertThat(points3.get(1)).isEqualTo(Point.of(3, 4));
        assertThat(points3.get(2)).isEqualTo(Point.of(5, 6));
        assertThat(points3.get(3)).isEqualTo(Point.of(7, 8));
    }

    @Test
    void parsePointsInput_IllegalPointsException() {
        Exception exception = assertThrows(IllegalPointsException.class, () -> service.parsePointsInput("(13)-(14)"));

        assertThat(exception.getMessage()).isEqualTo(IllegalPointsException.ILLEGAL_POINTS_MESSAGE);

        assertThrows(IllegalPointsException.class, () -> service.parsePointsInput("(14,15)"));
        assertThrows(IllegalPointsException.class, () -> service.parsePointsInput("(13)-(14,15)"));
        assertThrows(IllegalPointsException.class, () -> service.parsePointsInput("(13,14)-(14)"));
        assertThrows(IllegalPointsException.class, () -> service.parsePointsInput("(13,14)(14,15)"));
    }
}