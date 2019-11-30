package coordinate.domain.point;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PointTest {

    @Test
    void 논리적_동치성_검사() {
        final Point point1 = Point.of(10, 11);
        final Point point2 = Point.of(10, 11);

        assertThat(point1).isEqualTo(point2);
        assertThat(point1 == point2).isFalse();
    }

    @Test
    void Point_두개_거리() {
        final Point point1 = Point.of(10, 10);
        final Point point2 = Point.of(14, 15);
        final double expected = 6.403124;

        final double actual = point1.distanceTo(point2);

        assertThat(actual).isEqualTo(expected, offset(0.0009));
    }
}