package coordinates.domain;

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
        assertThat(yCoordinate.getY()).isEqualTo(1);
    }

    @Test
    void create_OutOfCoordinateBoundException() {
        assertThrows(OutOfYCoordinateBoundException.class, () -> YCoordinate.from(0));
        Exception exception = assertThrows(OutOfYCoordinateBoundException.class, () -> YCoordinate.from(25));

        assertThat(exception.getMessage()).isEqualTo(OutOfYCoordinateBoundException.OUT_OF_Y_COORDINATE_BOUND_MESSAGE);
    }

    @Test
    void equals() {
        assertThat(yCoordinate).isEqualTo(YCoordinate.from(1));
    }
}