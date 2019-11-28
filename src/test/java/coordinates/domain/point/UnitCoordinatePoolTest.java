package coordinates.domain.point;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UnitCoordinatePoolTest {

    @Test
    void get() {
        UnitCoordinate unitCoordinate = UnitCoordinatePool.get(1);

        assertThat(unitCoordinate == UnitCoordinatePool.get(1)).isTrue();
    }
}