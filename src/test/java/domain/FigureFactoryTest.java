package domain;

import domain.coordinate.XCoordinate;
import domain.coordinate.YCoordinate;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FigureFactoryTest {
    @Test
    @DisplayName("점을 두 개 입력받으면 라인을 생성한다.")
    void lineCreationTest() {
        Figure figure = FigureFactory.of(Lists.newArrayList(
                Point.of(XCoordinate.from(1), YCoordinate.from(1)),
                Point.of(XCoordinate.from(2), YCoordinate.from(2))
        ));

        assertThat(figure.getType()).isEqualTo(FigureType.LINE);
    }

    @Test
    @DisplayName("점을 세 개 입력받으면 삼각형을 생성한다.")
    void triangleCreationTest() {
        Figure figure = FigureFactory.of(Lists.newArrayList(
                Point.of(XCoordinate.from(1), YCoordinate.from(1)),
                Point.of(XCoordinate.from(2), YCoordinate.from(2)),
                Point.of(XCoordinate.from(2), YCoordinate.from(5))
        ));

        assertThat(figure.getType()).isEqualTo(FigureType.TRIANGLE);
    }

    @Test
    @DisplayName("점을 네 개 입력받으면 사각형을 생성한다.")
    void rectangleCreationTest() {
        Figure figure = FigureFactory.of(Lists.newArrayList(
                Point.of(XCoordinate.from(0), YCoordinate.from(0)),
                Point.of(XCoordinate.from(5), YCoordinate.from(0)),
                Point.of(XCoordinate.from(0), YCoordinate.from(5)),
                Point.of(XCoordinate.from(5), YCoordinate.from(5))
        ));

        assertThat(figure.getType()).isEqualTo(FigureType.RECTANGLE);
    }
}