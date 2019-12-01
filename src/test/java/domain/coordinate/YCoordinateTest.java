package domain.coordinate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class YCoordinateTest {
    @Test
    @DisplayName("Y 좌표는 0 미만의 값을 가질 수 없다.")
    void YCoordinateValueUnderflowTest() {
        assertThrows(IllegalArgumentException.class, () -> YCoordinate.from(-1));
    }

    @Test
    @DisplayName("Y 좌표는 24를 초과하는 값을 가질 수 없다.")
    void YCoordinateValueOverflowTest() {
        assertThrows(IllegalArgumentException.class, () -> YCoordinate.from(25));
    }

    @Test
    @DisplayName("같은 Y 좌표에 대해서 같은 객체임을 보장한다. (Identity Check)")
    void YCoordinateIdentityTest() {
        assertThat(YCoordinate.from(0) == YCoordinate.from(0)).isTrue();
    }

    @Test
    @DisplayName("같은 값을 갖는 Y 좌표는 동일하다. (Equality Check)")
    void YCoordinateEqualityTest() {
        assertThat(YCoordinate.from(0)).isEqualTo(YCoordinate.from(0));
    }
}