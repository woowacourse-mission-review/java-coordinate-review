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

    @Test
    @DisplayName("Coordinates Retrieve Value 테스트")
    void coordinates_retrieve_test() {
        Coordinate coordinate = new Coordinate(10);
        assertThat(coordinate.getValue()).isEqualTo(10);
    }
}