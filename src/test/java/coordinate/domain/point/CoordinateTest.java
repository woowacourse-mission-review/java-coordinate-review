package coordinate.domain.point;

import org.junit.jupiter.api.Test;

import static coordinate.domain.point.Coordinate.MAX_VALUE;
import static coordinate.domain.point.Coordinate.MIN_VALUE;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateTest {

    @Test
    void 정상_생성_확인() {
        Coordinate coordinate = Coordinate.of(MAX_VALUE - 1);
        assertThat(coordinate.value()).isEqualTo(MAX_VALUE - 1);
    }

    @Test
    void 캐싱_확인() {
        Coordinate coordinate1 = Coordinate.of(23);
        Coordinate coordinate2 = Coordinate.of(23);

        assertSame(coordinate1, coordinate2);
    }

    @Test
    void createException_최소값_미만() {
        String expected = String.format(Coordinate.RANGE_EXCEPTION_MESSAGE, MIN_VALUE, MAX_VALUE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Coordinate.of(MIN_VALUE - 1));

        assertThat(exception.getMessage()).isEqualTo(expected);
    }

    @Test
    void createException_최대값_미만() {
        String expected = String.format(Coordinate.RANGE_EXCEPTION_MESSAGE, MIN_VALUE, MAX_VALUE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Coordinate.of(MAX_VALUE + 1));

        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}