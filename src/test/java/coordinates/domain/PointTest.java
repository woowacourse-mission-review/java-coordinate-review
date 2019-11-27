package coordinates.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    private Point point;

    @BeforeEach
    void setUp() {
        point = Point.of(1, 2);
    }

    @Test
    void create() {
        assertThat(point).isNotNull();
        assertThat(point.getX()).isEqualTo(1);
        assertThat(point.getY()).isEqualTo(2);
    }

    @Test
    void equals() {
        assertThat(point).isEqualTo(Point.of(1, 2));
    }

    @Test
    void match() {
        assertThat(point.match(1, 2)).isTrue();

        assertThat(point.match(1, 3)).isFalse();
        assertThat(point.match(3, 2)).isFalse();
    }
}