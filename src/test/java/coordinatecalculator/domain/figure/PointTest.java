package coordinatecalculator.domain.figure;

import coordinatecalculator.domain.coordinates.exception.InvalidCoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MAX_Y_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MIN_Y_COORDINATE;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("Point 생성")
    void generate_point() {
        assertDoesNotThrow(() -> Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE));
        assertDoesNotThrow(() -> Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE));
        assertDoesNotThrow(() -> Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE));
        assertDoesNotThrow(() -> Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE));
    }

    @Test
    @DisplayName("X 좌표가 최솟값보다 작은 경우 에러")
    void generate_point_under_min_x_coordinate() {
        assertThrows(InvalidCoordinateException.class, () -> Point.of(MIN_X_COORDINATE - 1, MIN_Y_COORDINATE));
        assertThrows(InvalidCoordinateException.class, () -> Point.of(MIN_X_COORDINATE - 1, MAX_Y_COORDINATE));
    }

    @Test
    @DisplayName("X 좌표가 최댓값보다 큰 경우 에러")
    void generate_point_over_max_x_coordinate() {
        assertThrows(InvalidCoordinateException.class, () -> Point.of(MAX_X_COORDINATE + 1, MIN_Y_COORDINATE));
        assertThrows(InvalidCoordinateException.class, () -> Point.of(MAX_X_COORDINATE + 1, MAX_Y_COORDINATE));
    }

    @Test
    @DisplayName("Y 좌표가 최솟값보다 작은 경우 에러")
    void generate_point_under_min_y_coordinate() {
        assertThrows(InvalidCoordinateException.class, () -> Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE - 1));
        assertThrows(InvalidCoordinateException.class, () -> Point.of(MAX_X_COORDINATE, MIN_Y_COORDINATE - 1));
    }

    @Test
    @DisplayName("Y 좌표가 최댓값보다 큰 경우 에러")
    void generate_point_over_max_y_coordinate() {
        assertThrows(InvalidCoordinateException.class, () -> Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE + 1));
        assertThrows(InvalidCoordinateException.class, () -> Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE + 1));
    }

    @Test
    @DisplayName("같은 좌표의 Point 간 객체 비교")
    void equals() {
        int xCoordinate = 15;
        int yCoordinate = 15;
        assertEquals(Point.of(xCoordinate, yCoordinate), Point.of(xCoordinate, yCoordinate));
    }
}