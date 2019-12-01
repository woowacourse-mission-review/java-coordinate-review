package domain;

import domain.coordinate.XCoordinate;
import domain.coordinate.YCoordinate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void XGetterTest() {
        assertThat(Point.of(XCoordinate.from(0), YCoordinate.from(0)).getX()).isEqualTo(0);
    }

    @Test
    void YGetterTest() {
        assertThat(Point.of(XCoordinate.from(0), YCoordinate.from(0)).getY()).isEqualTo(0);
    }
}