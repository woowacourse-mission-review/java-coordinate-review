package coordinate.domain.point;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PointTest {
    private final Point point1 = Point.of(10, 10);
    private final Point point2 = Point.of(14, 15);

    @Test
    void 논리적_동치성_검사() {
        final Point point1 = Point.of(10, 11);
        final Point point2 = Point.of(10, 11);

        assertThat(point1).isEqualTo(point2);
        assertThat(point1 == point2).isFalse();
    }

    @Test
    void Point_두개_거리() {
        final double expected = 6.403124;

        final double actual = point1.distanceTo(point2);

        assertThat(actual).isEqualTo(expected, offset(0.0009));
    }

    @Test
    void distanceXToTest() {
        double expected = -4;
        double actual = point1.distanceXTo(point2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void distanceYToTest() {
        double expected = -5;
        double actual = point1.distanceYTo(point2);

        assertThat(actual).isEqualTo(expected);
    }
}