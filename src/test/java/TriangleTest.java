import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    private final Coordinate x1 = CoordinateFactory.get("10");
    private final Coordinate y1 = CoordinateFactory.get("10");
    private final Coordinate x2 = CoordinateFactory.get("14");
    private final Coordinate y2 = CoordinateFactory.get("15");
    private final Coordinate x3 = CoordinateFactory.get("20");
    private final Coordinate y3 = CoordinateFactory.get("8");

    private final Point p1 = new Point(x1, y1);
    private final Point p2 = new Point(x2, y2);
    private final Point p3 = new Point(x3, y3);

    @Test
    @DisplayName("세 점을 사용하여 삼각형을 생성한다.")
    void create_Triangle() {
        assertDoesNotThrow(() -> new Triangle(Arrays.asList(p1, p2, p3)));
    }

    @Test
    @DisplayName("중복된 점으로 삼각형 생성시 예외가 발생한다.")
    void create_duplicated_points() {
        assertThrows(DuplicatePointException.class, () -> new Triangle(Arrays.asList(p1, p1, p2)));
    }

    @Test
    @DisplayName("삼각형의 넓이를 구한다.")
    void get_area() {
        Triangle triangle = new Triangle(Arrays.asList(p1, p2, p3));

        assertThat(triangle.area()).isEqualTo(29.0, offset(0.099));
    }
}
