package coordinates.domain.point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

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

    @Test
    void calculateDistanceTo() {
        Point point2 = Point.of(3, 4);
        assertThat(point.calculateDistanceTo(point2)).isEqualTo(2.828, offset(0.00099));
    }
}