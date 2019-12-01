import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    private final Coordinate x1 = CoordinateFactory.get("10");
    private final Coordinate y1 = CoordinateFactory.get("10");
    private final Coordinate x2 = CoordinateFactory.get("14");
    private final Coordinate y2 = CoordinateFactory.get("15");

    private final Point p1 = new Point(x1, y1);
    private final Point p2 = new Point(x2, y2);

    @Test
    @DisplayName("두 점을 가지는 Line 객체를 생성한다.")
    void create_Lint() {
        assertDoesNotThrow(() -> new Line(p1, p2));
    }

    @Test
    @DisplayName("두 점이 같은 Line 객체를 생성할 시 예외를 발생시킨다.")
    void create_same_points_line() {
        assertThrows(InvalidLineException.class, () -> new Line(p1, p1));
    }

    @Test
    @DisplayName("선의 길이를 구한다.(두 점 사이의 거리를 구한다.)")
    void calculate_distance() {
        Line line = new Line(p1, p2);

        assertThat(line.length()).isEqualTo(6.4031241, offset(0.00099));
    }
}
