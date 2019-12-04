package coordinates.domain.figure;

import coordinates.domain.point.Point;
import coordinates.domain.point.Points;
import coordinates.exception.IllegalFigureCreationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    private Points points;

    @BeforeEach
    void setUp() {
        List<Point> pointList = Arrays.asList(Point.of(1, 2), Point.of(3, 4));
        points = Points.from(pointList);
    }

    @Test
    void create_IllegalFigureCreationException() {
        List<Point> pointList = Arrays.asList(Point.of(1, 2), Point.of(3, 4), Point.of(5, 6));
        Points points = Points.from(pointList);

        assertThrows(IllegalFigureCreationException.class, () -> Line.from(points));
    }

    @Test
    void size() {
        Line line = Line.from(points);
        assertThat(line.size()).isEqualTo(2);
    }

    @Test
    void area() {
        Line line = Line.from(points);
        assertThat(line.area()).isEqualTo(2.828, offset(0.00099));
    }
}