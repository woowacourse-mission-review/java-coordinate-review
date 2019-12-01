package domain;

import domain.coordinate.XCoordinate;
import domain.coordinate.YCoordinate;
import org.assertj.core.data.Offset;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {
    private Triangle testTriangle;

    @BeforeEach
    void setUp() {
        testTriangle = Triangle.of(
                Lists.newArrayList(
                        Point.of(XCoordinate.from(0), YCoordinate.from(0)),
                        Point.of(XCoordinate.from(5), YCoordinate.from(0)),
                        Point.of(XCoordinate.from(0), YCoordinate.from(5))
                )
        );
    }

    @Test
    @DisplayName("삼각형의 세 점이 한 직선 위에 놓여있으면 예외를 던진다.")
    void threePointsCannotLieInOneLine() {
        assertThrows(IllegalArgumentException.class,
                () -> Triangle.of(
                        Lists.newArrayList(
                                Point.of(XCoordinate.from(0), YCoordinate.from(0)),
                                Point.of(XCoordinate.from(1), YCoordinate.from(1)),
                                Point.of(XCoordinate.from(2), YCoordinate.from(2))
                        )
                )
        );
    }

    @Test
    void returnLineFigureTypeTest() {
        assertThat(testTriangle.getType()).isEqualTo(FigureType.TRIANGLE);
    }

    @Test
    void calculateDistance() {
        assertThat(testTriangle.calculate()).isEqualTo(5.0 * 5.0 / 2.0, Offset.offset(0.001));
    }
}