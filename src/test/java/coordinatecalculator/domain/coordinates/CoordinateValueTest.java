package coordinatecalculator.domain.coordinates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateValueTest {

    private final int coordinate = 1;

    @Test
    @DisplayName("좌표 생성")
    void generate_coordinate() {
        assertDoesNotThrow(() -> CoordinateValue.of(coordinate));
    }

    @Test
    @DisplayName("value() 메소드 정상 동작")
    void get_coordinate() {
        assertEquals(CoordinateValue.of(coordinate).value(), coordinate);
    }
}