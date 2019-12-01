package coordinatecalculator.domain.figure;

import coordinatecalculator.domain.figure.exception.InvalidFigureCreationException;
import coordinatecalculator.domain.figure.line.Line;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static coordinatecalculator.domain.coordinates.XCoordinate.MAX_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.XCoordinate.MIN_X_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MAX_Y_COORDINATE;
import static coordinatecalculator.domain.coordinates.YCoordinate.MIN_Y_COORDINATE;
import static coordinatecalculator.domain.figure.FigureFactory.INVALID_FIGURE_CREATION_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class FigureFactoryTest {

    private FigureFactory figureFactory = new FigureFactory();

    @Test
    @DisplayName("점들을 처리할 수 있는 FigureCreator 가 없는 경우 에러가 발생하는지")
    void create_figure_no_creator() {
        Point point = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point);

        InvalidFigureCreationException exception = assertThrows(InvalidFigureCreationException.class
                , () -> figureFactory.createFigure(points));
        assertEquals(exception.getMessage(), INVALID_FIGURE_CREATION_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("두 개의 다른 점을 입력했을 경우 직선을 정상적으로 만드는지")
    void create_line_with_two_points() {
        Point point1 = Point.of(MIN_X_COORDINATE, MIN_Y_COORDINATE);
        Point point2 = Point.of(MAX_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point1, point2);

        Figure figure = assertDoesNotThrow(() -> figureFactory.createFigure(points));
        assertTrue(figure instanceof Line);
        assertTrue(figure.contains(point1));
        assertTrue(figure.contains(point2));
    }

    @Test
    @DisplayName("같은 두 점을 입력했을 경우 에러가 발생하는지")
    void create_line_with_same_points() {
        Point point = Point.of(MIN_X_COORDINATE, MAX_Y_COORDINATE);
        List<Point> points = Lists.newArrayList(point, point);

        InvalidFigureCreationException exception = assertThrows(InvalidFigureCreationException.class
                , () -> figureFactory.createFigure(points));
        assertEquals(exception.getMessage(), INVALID_FIGURE_CREATION_EXCEPTION_MESSAGE);
    }
}