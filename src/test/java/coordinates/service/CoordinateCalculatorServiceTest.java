package coordinates.service;

import coordinates.exception.IllegalPointsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateCalculatorServiceTest {

    private CoordinateCalculatorService service;

    @BeforeEach
    void setUp() {
        service = new CoordinateCalculatorService();
    }

    @Test
    void parsePointsInput() {
        assertThat(service.parsePointsInput("(10, 10) - (14, 15)")).isNotNull();
        assertThat(service.parsePointsInput("(10, 10) - (14, 15)-(13, 14)")).isNotNull();
        assertThat(service.parsePointsInput("(10, 10) - (14, 15)-(13, 14)-(15, 16)")).isNotNull();
    }

    @Test
    void parsePointsInput_IllegalPointsException() {
        Exception exception = assertThrows(IllegalPointsException.class, () -> service.parsePointsInput("(13)-(14)"));

        assertThat(exception.getMessage()).isEqualTo(IllegalPointsException.ILLEGAL_POINTS_MESSAGE);

        assertThrows(IllegalPointsException.class, () -> service.parsePointsInput("(13)-(14,15)"));
        assertThrows(IllegalPointsException.class, () -> service.parsePointsInput("(13,14)-(14)"));
        assertThrows(IllegalPointsException.class, () -> service.parsePointsInput("(13,14)(14,15)"));
    }
}