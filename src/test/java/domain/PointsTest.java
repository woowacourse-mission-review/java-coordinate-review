package domain;

import exception.DuplicatePointsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointsTest {
    @Test
    @DisplayName("Points 생성테스트")
    void points_constructor_test() {
        Points points = new Points("(1,2)-(3,4)");
        assertThat(points.getPointAt(0)).isEqualTo(new Point("1,2"));
        assertThat(points.getPointAt(1)).isEqualTo(new Point("3,4"));
    }

    @Test
    @DisplayName("Points 생성테스트")
    void points_constructor_test2() {
        Points points = new Points("(1,    2)-(   3,   4)");
        assertThat(points.getPointAt(0)).isEqualTo(new Point("1,2"));
        assertThat(points.getPointAt(1)).isEqualTo(new Point("3,4"));
    }

    @Test
    @DisplayName("Points 생성테스트 예외, 중복된 숫자가 있을 때")
    void fail_points_constructor_test() {
        assertThrows(DuplicatePointsException.class, () -> new Points("(1,2)-(1,2)"));
    }

    @Test
    @DisplayName("Points 거리구하기")
    void calculate_distance_test() {
        Points points = new Points("(0,0)-(6,11)");
        assertThat(points.calculateDistance(0, 1)).isEqualTo(Math.sqrt(157));
    }

    @Test
    @DisplayName("직각인 두 선분의 사이즈 구하기")
    void find_perpendicular_sides_sizes_test() {
        Points points = new Points("(0,0)-(4,0)-(0,2)-(4,2)");
        assertThat(points.findPerpendicularSidesSizes().size()).isEqualTo(2);
        assertThat(points.findPerpendicularSidesSizes().contains(4.0)).isTrue();
        assertThat(points.findPerpendicularSidesSizes().contains(2.0)).isTrue();
    }

    @Test
    @DisplayName("직각인 두 선분의 사이즈 구하기")
    void find_perpendicular_sides_sizes_test2() {
        Points points = new Points("(1,1)-(5,1)-(1,3)-(5,3)");
        assertThat(points.findPerpendicularSidesSizes().size()).isEqualTo(2);
        assertThat(points.findPerpendicularSidesSizes().contains(4.0)).isTrue();
        assertThat(points.findPerpendicularSidesSizes().contains(2.0)).isTrue();
    }
}