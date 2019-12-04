package coordinates.domain.figure;

import coordinates.domain.point.Point;
import coordinates.domain.point.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FigureFactoryTest {

    private FigureFactory figureFactory = FigureFactory.getInstance();

    @Test
    void getInstance() {
        assertThat(figureFactory == FigureFactory.getInstance()).isTrue();
    }

    @Test
    void create() {
        List<Point> twoPointList = Arrays.asList(Point.of(1, 2), Point.of(3, 4));
        List<Point> threePointList = Arrays.asList(Point.of(1, 2), Point.of(3, 4), Point.of(5, 6));
        List<Point> fourPointList = Arrays.asList(Point.of(1, 2), Point.of(3, 4), Point.of(1, 4), Point.of(3, 2));

        Points twoPoints = Points.from(twoPointList);
        Points threePoints = Points.from(threePointList);
        Points fourPoints = Points.from(fourPointList);

        assertThat(figureFactory.create(twoPoints)).isInstanceOf(Line.class);
        assertThat(figureFactory.create(threePoints)).isInstanceOf(Triangle.class);
        assertThat(figureFactory.create(fourPoints)).isInstanceOf(Rectangle.class);
    }
}