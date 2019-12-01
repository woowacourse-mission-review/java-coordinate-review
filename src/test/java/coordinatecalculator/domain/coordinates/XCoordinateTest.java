package coordinatecalculator.domain.coordinates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static org.junit.jupiter.api.Assertions.*;

class XCoordinateTest {

    @Test
    @DisplayName("X 좌표 생성")
    void generate_xCoordinate() {
        assertDoesNotThrow(() -> XCoordinate.of(1));
    }

    @Test
    @DisplayName("최소 좌표값 미만의 값을 입력할 경우 에러 발생")
    void generate_xCoordinate_under_min_boundary() {
        assertThrows(IllegalArgumentException.class, () -> XCoordinate.of(MIN_X_COORDINATE - 1));
    }

    @Test
    @DisplayName("최대 좌표값을 초과한 값을 입력할 경우 에러 발생")
    void generate_xCoordinate_over_max_boundary() {
        assertThrows(IllegalArgumentException.class, () -> XCoordinate.of(MAX_X_COORDINATE + 1));
    }

    @Test
    @DisplayName("of로 꺼내온 X 좌표가 같은 객체인지 확인")
    void assert_pooling() {
        assertSame(XCoordinate.of(2), XCoordinate.of(2));
    }

    @Test
    @DisplayName("X 좌표 값 확인")
    void get_coordinate() {
        int coordinate = 3;
        assertEquals(coordinate, XCoordinate.of(coordinate).value());
    }
}