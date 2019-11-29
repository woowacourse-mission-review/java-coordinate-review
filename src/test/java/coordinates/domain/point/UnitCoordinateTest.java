package coordinates.domain.point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UnitCoordinateTest {

    private UnitCoordinate unitCoordinate;

    @BeforeEach
    void setUp() {
        unitCoordinate = UnitCoordinatePool.get(2);
    }

    @Test
    void create() {
        assertThat(unitCoordinate).isNotNull();
        assertThat(unitCoordinate.getValue()).isEqualTo(2);
    }

    @Test
    void match() {
        assertThat(unitCoordinate.match(2)).isTrue();
        assertThat(unitCoordinate.match(3)).isFalse();
    }

    @Test
    void calculatePositiveDifference() {
        UnitCoordinate unitCoordinate2 = UnitCoordinatePool.get(10);

        assertThat(unitCoordinate.calculatePositiveDifference(unitCoordinate2)).isEqualTo(RelativeCoordinatePool.get(8));
        assertThat(unitCoordinate2.calculatePositiveDifference(unitCoordinate)).isEqualTo(RelativeCoordinatePool.get(8));
    }

    @Test
    void square() {
        assertThat(unitCoordinate.square()).isEqualTo(4);
    }

    @Test
    void multiply() {
        assertThat(unitCoordinate.multiply(UnitCoordinatePool.get(3))).isEqualTo(6.0);
    }
}