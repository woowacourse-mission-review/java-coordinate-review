package coordinatecalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateTest {

    private final int coordinate = 1;

    @Test
    @DisplayName("좌표 생성")
    void generate_coordinate() {
        assertDoesNotThrow(() -> Coordinate.of(coordinate));
    }

    @Test
    @DisplayName("value() 메소드 정상 동작")
    void get_coordinate() {
        assertEquals(Coordinate.of(coordinate).value(), coordinate);
    }
}