package coordinates.domain.point.unitcoordinate;

import coordinates.exception.OutOfYCoordinateBoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class YCoordinateTest {

    private YCoordinate yCoordinate;

    @BeforeEach
    void setUp() {
        yCoordinate = YCoordinate.from(1);
    }

    @Test
    void create() {
        assertThat(yCoordinate).isNotNull();
        assertThat(yCoordinate.value()).isEqualTo(1);
    }

    @Test
    void create_OutOfCoordinateBoundException() {
        assertThrows(OutOfYCoordinateBoundException.class, () -> YCoordinate.from(YCoordinate.LOWER_BOUND - 1));
        Exception exception = assertThrows(OutOfYCoordinateBoundException.class, () -> YCoordinate.from(YCoordinate.UPPER_BOUND + 1));

        assertThat(exception.getMessage()).isEqualTo(OutOfYCoordinateBoundException.OUT_OF_Y_COORDINATE_BOUND_MESSAGE);
    }
}