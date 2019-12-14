package coordinate.domain.figure;

import coordinate.domain.point.Point;
import coordinate.domain.point.PointGroup;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FigureFactoryTest {

    @Test
    void createLineTest() {
        final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10), Point.of(14, 15)));
        final Figure figure = FigureFactory.create(pointGroup);

        assertThat(figure.getClass()).isEqualTo(Line.class);
    }

    @Test
    void createTriangleTest() {
        final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10), Point.of(14, 15), Point.of(20, 8)));
        final Figure figure = FigureFactory.create(pointGroup);

        assertThat(figure.getClass()).isEqualTo(Triangle.class);
    }

    @Test
    void createRectangleTest() {
        final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10), Point.of(10, 20), Point.of(20, 10), Point.of(20, 20)));
        final Figure figure = FigureFactory.create(pointGroup);

        assertThat(figure.getClass()).isEqualTo(Rectangle.class);
    }

    @Test
    void createExceptionTest() {
        final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10)));

        assertThrows(UnsupportedOperationException.class, () -> FigureFactory.create(pointGroup));
    }
}