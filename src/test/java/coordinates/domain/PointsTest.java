package coordinates.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {

    private Points points;

    @BeforeEach
    void setUp() {
        List<Point> pointList = Arrays.asList(Point.of(1, 2), Point.of(3, 4));
        points = Points.from(pointList);
    }

    @Test
    void create() {
        assertThat(points).isNotNull();
    }

    @Test
    void size() {
        assertThat(points.size()).isEqualTo(2);
    }

    @Test
    void get() {
        assertThat(points.get(0)).isEqualTo(Point.of(1, 2));
        assertThat(points.get(1)).isEqualTo(Point.of(3, 4));
    }

    @Test
    void contains() {
        assertThat(points.contains(1, 2)).isTrue();
        assertThat(points.contains(3, 4)).isTrue();

        assertThat(points.contains(1, 3)).isFalse();
    }
}