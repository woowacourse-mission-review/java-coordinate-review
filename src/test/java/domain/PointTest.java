package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PointTest {
    private final Coordinate x1 = CoordinateFactory.get("1");
    private final Coordinate y1 = CoordinateFactory.get("2");
    private final Coordinate x2 = CoordinateFactory.get("3");
    private final Coordinate y2 = CoordinateFactory.get("4");

    @Test
    @DisplayName("x, y 좌료를 가진 점을 생성한다.")
    void create_Point() {
        assertDoesNotThrow(() -> new Point(x1, y1));
    }

    @Test
    @DisplayName("X 좌표의 차이를 구한다.")
    void minus_X() {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        assertThat(p1.minusX(p2)).isEqualTo(-2);
    }

    @Test
    @DisplayName("X 좌표의 차이를 구한다.")
    void minus_Y() {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        assertThat(p2.minusY(p1)).isEqualTo(2);
    }
}
