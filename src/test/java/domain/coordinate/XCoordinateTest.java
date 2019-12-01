package domain.coordinate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class XCoordinateTest {
    @Test
    @DisplayName("X 좌표는 0 미만의 값을 가질 수 없다.")
    void XCoordinateValueUnderflowTest() {
        assertThrows(IllegalArgumentException.class, () -> XCoordinate.of(-1));
    }

    @Test
    @DisplayName("X 좌표는 24를 초과하는 값을 가질 수 없다.")
    void XCoordinateValueOverflowTest() {
        assertThrows(IllegalArgumentException.class, () -> XCoordinate.of(25));
    }

    @Test
    @DisplayName("같은 X 좌표에 대해서 같은 객체임을 보장한다. (Identity Check)")
    void XCoordinateIdentityTest() {
        assertThat(XCoordinate.of(0) == XCoordinate.of(0)).isTrue();
    }

    @Test
    @DisplayName("같은 값을 갖는 X 좌표는 동일하다. (Equality Check)")
    void XCoordinateEqualityTest() {
        assertThat(XCoordinate.of(0)).isEqualTo(XCoordinate.of(0));
    }
}