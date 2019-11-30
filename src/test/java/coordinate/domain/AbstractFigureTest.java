package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AbstractFigureTest {

    @Test
    void validateSizeTest() {
        // given
        final String name = "삼각형";
        final int sizeOfPointGroup = 3;
        final String actualMessage = String.format(AbstractFigure.POINTS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE, name, sizeOfPointGroup);
        final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10), Point.of(14, 15)));

        // when & then
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new AbstractFigure(pointGroup, sizeOfPointGroup) {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public double area() {
                return 0;
            }

            @Override
            public String getName() {
                return name;
            }
        });

        assertThat(exception.getMessage()).isEqualTo(actualMessage);
    }
}