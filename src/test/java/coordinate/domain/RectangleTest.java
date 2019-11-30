package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static coordinate.domain.Rectangle.POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10), Point.of(10, 20), Point.of(20, 10), Point.of(20, 20)));
    final Rectangle rectangle = Rectangle.of(pointGroup);

    @Test
    void Points_size_4가_아닌_경우_예외처리() {
        final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10), Point.of(14, 15), Point.of(14, 19)));
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rectangle.of(pointGroup));

        assertThat(exception.getMessage()).isEqualTo(POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE);
    }

    @Test
    void 직사각형이_아니면_예외처리() {
        final PointGroup pointGroup = PointGroup.of(List.of(Point.of(15, 15), Point.of(10, 20), Point.of(20, 10), Point.of(20, 20)));
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Rectangle.of(pointGroup));

        assertThat(exception.getMessage()).isEqualTo("직사각형이 아닙니다");
    }

    @Test
    void sizeTest() {
        assertThat(rectangle.size()).isEqualTo(Rectangle.SIZE_OF_POINTS);
    }

    @Test
    void areaTest() {
        final double expected = 100;

        assertThat(rectangle.area()).isEqualTo(expected, offset(0.099));
    }
}