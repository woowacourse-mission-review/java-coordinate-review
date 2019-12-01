import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {

    @Test
    @DisplayName("좌표 하나를 정상적으로 생성한다.")
    void create_coordinate() {
        assertDoesNotThrow(() -> new Coordinate("1"));
    }

    @Test
    @DisplayName("24보다 큰 좌표를 생성할 때 오류가 발생한다.")
    void create_over_24() {
        assertThrows(InvalidCoordinateException.class, () -> new Coordinate("25"));
    }

    @Test
    @DisplayName("0보다 작은 좌표를 생성할 때 오류가 발생한다.")
    void create_under_0() {
        assertThrows(InvalidCoordinateException.class, () -> new Coordinate("-1"));
    }

    @Test
    @DisplayName("정수가 아닌 문자열로 좌표를 생성할 떄 오류가 발생한다.")
    void create_not_integer() {
        assertThrows(InvalidCoordinateException.class, () -> new Coordinate("1.5"));
        assertThrows(InvalidCoordinateException.class, () -> new Coordinate("a"));
    }

    @Test
    @DisplayName("두 좌표의 차이를 구한다.")
    void minus() {
        Coordinate x1 = new Coordinate("2");
        Coordinate x2 = new Coordinate("1");

        assertThat(x1.minus(x2)).isEqualTo(1);
    }
}
