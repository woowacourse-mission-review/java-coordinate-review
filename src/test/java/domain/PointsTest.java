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
}