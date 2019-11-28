package coordinates.domain.point;

import coordinates.exception.OutOfXCoordinateBoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class XCoordinateTest {

    private XCoordinate xCoordinate;

    @BeforeEach
    void setUp() {
        xCoordinate = XCoordinate.from(1);
    }

    @Test
    void create() {
        assertThat(xCoordinate).isNotNull();
        assertThat(xCoordinate.getX()).isEqualTo(1);
    }

    @Test
    void create_OutOfCoordinateBoundException() {
        assertThrows(OutOfXCoordinateBoundException.class, () -> XCoordinate.from(0));
        Exception exception = assertThrows(OutOfXCoordinateBoundException.class, () -> XCoordinate.from(25));

        assertThat(exception.getMessage()).isEqualTo(OutOfXCoordinateBoundException.OUT_OF_X_COORDINATE_BOUND_MESSAGE);
    }

    @Test
    void equals() {
        assertThat(xCoordinate).isEqualTo(XCoordinate.from(1));
    }

    @Test
    void match() {
        assertThat(xCoordinate.match(1)).isTrue();
        assertThat(xCoordinate.match(2)).isFalse();
    }
}