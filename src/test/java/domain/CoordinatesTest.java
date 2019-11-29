package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinatesTest {
    @Test
    @DisplayName("Coordinates 생성테스트")
    void coordinates_constructor_test() {
        assertThat(Coordinates.size()).isEqualTo(25);
    }
}