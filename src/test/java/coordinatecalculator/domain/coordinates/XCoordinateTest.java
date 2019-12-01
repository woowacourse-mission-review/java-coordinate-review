package coordinatecalculator.domain.coordinates;

import coordinatecalculator.domain.coordinates.exception.InvalidCoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coordinatecalculator.domain.coordinates.XCoordinate.*;
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
        InvalidCoordinateException exception = assertThrows(InvalidCoordinateException.class
                , () -> XCoordinate.of(MIN_X_COORDINATE - 1));
        assertEquals(exception.getMessage(), X_COORDINATE_INVALID_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("최대 좌표값을 초과한 값을 입력할 경우 에러 발생")
    void generate_xCoordinate_over_max_boundary() {
        InvalidCoordinateException exception = assertThrows(InvalidCoordinateException.class
                , () -> XCoordinate.of(MAX_X_COORDINATE + 1));
        assertEquals(exception.getMessage(), X_COORDINATE_INVALID_EXCEPTION_MESSAGE);
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