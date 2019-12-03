package coordinatecalculator.service;

import coordinatecalculator.domain.InvalidInputFormatException;
import coordinatecalculator.domain.figure.Point;
import coordinatecalculator.domain.figure.exception.InvalidFigureCreationException;
import coordinatecalculator.domain.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coordinatecalculator.domain.figure.FigureFactory.INVALID_FIGURE_CREATION_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateCalculatorServiceTest {

    private final CoordinateCalculatorService service = new CoordinateCalculatorService();

    @Test
    @DisplayName("두 개의 다른 점을 입력한 경우")
    void calculate_two_different_points() {
        String input = "(1,2)-(3,4)";

        Result result = service.calculate(input);
        assertTrue(result.contains(Point.of(1, 2)));
        assertTrue(result.contains(Point.of(3, 4)));
    }

    @Test
    @DisplayName("한 개의 점을 입력한 경우")
    void calculate_one_point() {
        String input = "(1,2)";

        InvalidFigureCreationException exception = assertThrows(InvalidFigureCreationException.class
                , () -> service.calculate(input));
        assertEquals(exception.getMessage(), INVALID_FIGURE_CREATION_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("4개 초과의 점을 입력한 경우")
    void calculate_over_4_points() {
        String input = "(1,1)-(20,10)-(1,10)-(20,10)-(10,20)";

        InvalidFigureCreationException exception = assertThrows(InvalidFigureCreationException.class
                , () -> service.calculate(input));
        assertEquals(exception.getMessage(), INVALID_FIGURE_CREATION_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("잘못된 점들의 DELIMITER 를 사용한 경우")
    void calculate_wrong_point_delimiter_format() {
        String input = "(1,2)=(3,4)";

        assertThrows(InvalidInputFormatException.class, () -> service.calculate(input));
    }

    @Test
    @DisplayName("잘못된 좌표들의 DELIMITER 를 사용한 경우")
    void calculate_wrong_coordinate_delimiter_format() {
        String input = "(1_2)-(3_4)";

        assertThrows(InvalidInputFormatException.class, () -> service.calculate(input));
    }

    @Test
    @DisplayName("정수가 아닌 값들을 좌표값으로 입력한 경우")
    void calculate_not_integer_point_format() {
        String input = "(one,two)-(three,four)";

        assertThrows(InvalidInputFormatException.class, () -> service.calculate(input));
    }
}