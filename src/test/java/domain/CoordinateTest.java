package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {
    @Test
    @DisplayName("좌표생성 테스트")
    void coordinate_constructor_test() {
        Coordinate coordinate = new Coordinate(1);
        assertThat(coordinate.getValue()).isEqualTo(1);
    }

}