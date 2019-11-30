package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateTest {
    @Test
    @DisplayName("좌표생성 테스트")
    void coordinate_constructor_test() {
        Coordinate coordinate = new Coordinate(1);
        assertThat(coordinate.getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("좌표 싱글인스턴스인지 확인")
    void check_single_instance() {
        assertThat(Coordinates.retrieveValue(10) == Coordinates.retrieveValue(10)).isTrue();
    }

    @Test
    @DisplayName("두 좌표 사이의 차이의 제곱 계산")
    void calculate_squared_distance() {
        Coordinate coordinate1 = new Coordinate(10);
        Coordinate coordinate2 = new Coordinate(15);
        assertThat(coordinate1.calculateSquaredDistance(coordinate2)).isEqualTo(25);
    }

    @Test
    @DisplayName("두 좌표 사이의 차이의 제곱 계산")
    void calculate_squared_distance2() {
        Coordinate coordinate1 = new Coordinate(1);
        Coordinate coordinate2 = new Coordinate(24);
        assertThat(coordinate1.calculateSquaredDistance(coordinate2)).isEqualTo(Math.pow(23,2));
    }

    @Test
    @DisplayName("두 좌표 사이의 차이의 제곱 계산")
    void calculate_squared_distance3() {
        Coordinate coordinate1 = new Coordinate(-5);
        Coordinate coordinate2 = new Coordinate(24);
        assertThat(coordinate1.calculateSquaredDistance(coordinate2)).isEqualTo(Math.pow(-29,2));
    }
}