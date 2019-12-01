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

class LineTest {
    private Line testLine;

    @BeforeEach
    void setUp() {
        testLine = Line.of(
                Lists.newArrayList(
                        Point.of(XCoordinate.from(0), YCoordinate.from(0)),
                        Point.of(XCoordinate.from(5), YCoordinate.from(0))
                )
        );
    }

    @Test
    @DisplayName("두 개 미만의 점들을 인자로 받으면 예외를 던진다.")
    void cannotTakeSmallerThanTwoPoints() {
        assertThrows(IllegalArgumentException.class, () ->
                Line.of(
                        Lists.newArrayList(
                                Point.of(XCoordinate.from(0), YCoordinate.from(0))
                        )
                )
        );
    }

    @Test
    @DisplayName("두 개 초과하는 점들을 인자로 받으면 예외를 던진다.")
    void cannotTakeBiggerThanTwoPoints() {
        assertThrows(IllegalArgumentException.class, () ->
                Line.of(
                        Lists.newArrayList(
                                Point.of(XCoordinate.from(0), YCoordinate.from(0)),
                                Point.of(XCoordinate.from(1), YCoordinate.from(0)),
                                Point.of(XCoordinate.from(0), YCoordinate.from(1))
                        )
                )
        );
    }

    @Test
    @DisplayName("점들이 중복되면 안 된다.")
    void cannotTakeDuplicatedPoints() {
        assertThrows(IllegalArgumentException.class, () ->
                Line.of(
                        Lists.newArrayList(
                                Point.of(XCoordinate.from(0), YCoordinate.from(0)),
                                Point.of(XCoordinate.from(0), YCoordinate.from(0))
                        )
                )
        );
    }

    @Test
    void returnLineFigureTypeTest() {
        assertThat(testLine.getType()).isEqualTo(FigureType.LINE);
    }

    @Test
    void calculateDistance() {
        assertThat(testLine.calculate()).isEqualTo(5.0, Offset.offset(0.001));
    }
}