import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PointTest {

    @Test
    @DisplayName("x, y 좌료를 가진 점을 생성한다.")
    void create_Point() {
        Coordinate x = CoordinateFactory.get("1");
        Coordinate y = CoordinateFactory.get("2");
        assertDoesNotThrow(() -> new Point(x, y));
    }
}
