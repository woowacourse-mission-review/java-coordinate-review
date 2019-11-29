package coordinates.domain.point;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RelativeCoordinatePoolTest {

    @Test
    void get() {
        RelativeCoordinate relativeCoordinate = RelativeCoordinatePool.get(1);

        assertThat(relativeCoordinate == RelativeCoordinatePool.get(1)).isTrue();
    }
}