package coordinates.domain.figure;

import coordinates.domain.point.Point;
import coordinates.domain.point.Points;
import coordinates.exception.IllegalFigureCreationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    private Points points;

    @BeforeEach
    void setUp() {
        List<Point> pointList = Arrays.asList(Point.of(1, 2), Point.of(3, 2), Point.of(1, 5), Point.of(3, 5));
        points = Points.from(pointList);
    }

    @Test
    void create_IllegalFigureCreationException() {
        List<Point> pointList = Arrays.asList(Point.of(1, 2), Point.of(3, 4));
        Points points = Points.from(pointList);

        assertThrows(IllegalFigureCreationException.class, () -> Rectangle.from(points));
    }

    @Test
    void size() {
        Rectangle rectangle = Rectangle.from(points);
        assertThat(rectangle.size()).isEqualTo(4);
    }

    @Test
    void area() {
        Rectangle rectangle = Rectangle.from(points);
        assertThat(rectangle.area()).isEqualTo(6.0);
    }
}