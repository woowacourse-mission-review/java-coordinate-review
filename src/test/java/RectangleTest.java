import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RectangleTest {
    private final Coordinate x1 = CoordinateFactory.get("10");
    private final Coordinate y1 = CoordinateFactory.get("10");
    private final Coordinate x2 = CoordinateFactory.get("22");
    private final Coordinate y2 = CoordinateFactory.get("10");
    private final Coordinate x3 = CoordinateFactory.get("22");
    private final Coordinate y3 = CoordinateFactory.get("18");
    private final Coordinate x4 = CoordinateFactory.get("10");
    private final Coordinate y4 = CoordinateFactory.get("18");

    private final Point p1 = new Point(x1, y1);
    private final Point p2 = new Point(x2, y2);
    private final Point p3 = new Point(x3, y3);
    private final Point p4 = new Point(x4, y4);

    @Test
    @DisplayName("점 4개를 사용하여 사각형 객체를 정상적으로 생성한다.")
    void create_Rectangle() {
        assertDoesNotThrow(() -> new Rectangle(Arrays.asList(p1, p2, p3, p4)));
    }

    @Test
    @DisplayName("사각형의 넓이를 구한다.")
    void get_area() {
        Rectangle rectangle = new Rectangle(Arrays.asList(p1, p2, p3, p4));
        assertThat(rectangle.area()).isEqualTo(96);
    }
}
