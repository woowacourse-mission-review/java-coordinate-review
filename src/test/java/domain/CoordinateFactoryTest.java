package domain;

import domain.exception.InvalidCoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateFactoryTest {

    @Test
    @DisplayName("유효한 좌표값 가져오기")
    void get_valid_coordinate() {
        Coordinate coordinateX = CoordinateFactory.get("1");
        assertThat(coordinateX.value()).isEqualTo(1);
    }

    @Test
    @DisplayName("유효하지 않은 좌표값 가져오기")
    void get_invalid_coordinate() {
        assertThrows(InvalidCoordinateException.class, () -> CoordinateFactory.get("25"));
        assertThrows(InvalidCoordinateException.class, () -> CoordinateFactory.get("-1"));
        assertThrows(InvalidCoordinateException.class, () -> CoordinateFactory.get("a"));
    }

    @Test
    @DisplayName("유효한 좌표값을 가져올 때 같은 객체를 가져온다.")
    void valid_cache() {
        Coordinate source = CoordinateFactory.get("10");
        Coordinate target = CoordinateFactory.get("10");

        assertThat(source == target).isTrue();
    }
}
