package domain.figure;

import domain.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

class FigureFactoryTest {
    @Test
    @DisplayName("알맞는 Figure만들어지는지 test, line 만들기")
    void create_line() {
        Points points = new Points("(1,2)-(3,4)");
        Figure figure = FigureFactory.createFigure(points);
        assertThat(figure.getClass()).isEqualTo(Line.class);
    }

    @Test
    @DisplayName("알맞는 Figure만들어지는지 test, triangle 만들기")
    void create_triangle() {
        Points points = new Points("(1,2)-(3,4)-(5,6)");
        Figure figure = FigureFactory.createFigure(points);
        assertThat(figure.getClass()).isEqualTo(Triangle.class);
    }

    @Test
    @DisplayName("알맞는 Figure만들어지는지 test, rectangle 만들기")
    void create_rectangle() {
        Points points = new Points("(1,2)-(3,4)-(5,6)-(7,8)");
        Figure figure = FigureFactory.createFigure(points);
        assertThat(figure.getClass()).isEqualTo(Rectangle.class);
    }

}