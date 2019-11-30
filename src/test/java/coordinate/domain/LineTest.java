package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static coordinate.domain.Line.POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10), Point.of(14, 15)));
    final Line line = Line.of(pointGroup);

    @Test
    void Points_size_2가_아닌_경우_예외처리() {
        final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10), Point.of(14, 15), Point.of(14, 19)));
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Line.of(pointGroup));

        assertThat(exception.getMessage()).isEqualTo(POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE);
    }

    @Test
    void sizeTest() {
        assertThat(line.size()).isEqualTo(Line.SIZE_OF_POINTS);
    }

    @Test
    void lengthTest() {
        final double expected = 6.403124;

        assertThat(line.length()).isEqualTo(expected, offset(0.0009));
    }
}