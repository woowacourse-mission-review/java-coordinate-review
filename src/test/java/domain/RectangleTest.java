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

class RectangleTest {
    private Rectangle testRectangle;

    @BeforeEach
    void setUp() {
        testRectangle = Rectangle.of(
                Lists.newArrayList(
                        Point.of(XCoordinate.from(0), YCoordinate.from(0)),
                        Point.of(XCoordinate.from(5), YCoordinate.from(0)),
                        Point.of(XCoordinate.from(0), YCoordinate.from(5)),
                        Point.of(XCoordinate.from(5), YCoordinate.from(5))
                )
        );
    }

    @Test
    @DisplayName("직사각형이 아닌 사각형이 들어오면 예외를 던진다.")
    void wickedRectangleCannotInstantiated() {
        assertThrows(IllegalArgumentException.class, () -> Rectangle.of(
                Lists.newArrayList(
                        Point.of(XCoordinate.from(0), YCoordinate.from(0)),
                        Point.of(XCoordinate.from(6), YCoordinate.from(0)),
                        Point.of(XCoordinate.from(0), YCoordinate.from(5)),
                        Point.of(XCoordinate.from(5), YCoordinate.from(5))
                )
        ));
    }

    @Test
    void returnFigureTypeRectangle() {
        assertThat(testRectangle.getType()).isEqualTo(FigureType.RECTANGLE);
    }

    @Test
    void calculateArea() {
        assertThat(testRectangle.calculate()).isEqualTo(25.0, Offset.offset(0.001));
    }
}