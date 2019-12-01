package domain;

import domain.coordinate.XCoordinate;
import domain.coordinate.YCoordinate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VectorTest {
    @Test
    void calculateInnerProductTest() {
        Vector v1 = Vector.of(
                Point.of(XCoordinate.from(1), YCoordinate.from(1)),
                Point.of(XCoordinate.from(5), YCoordinate.from(5))
        ); // v1 = <4, 4>

        Vector v2 = Vector.of(
                Point.of(XCoordinate.from(2), YCoordinate.from(4)),
                Point.of(XCoordinate.from(7), YCoordinate.from(3))
        ); // v2 = <5, -1>

        assertThat(v1.innerProduct(v2)).isEqualTo(v2.innerProduct(v1));  // exchange rule holds
        assertThat(v1.innerProduct(v2)).isEqualTo(16);
    }
}