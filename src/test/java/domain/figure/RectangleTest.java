package domain.figure;

import domain.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class RectangleTest {
    @Test
    @DisplayName("정사각형 넓이 구하기")
    void calculate_square_area() {
        Points points = new Points("(4,4)-(0,0)-(0,4)-(4,0)");
        Figure rectangle = FigureFactory.createFigure(points);
        assertThat(rectangle.calculateDistanceOrArea()).isEqualTo(16, offset(0.000009));
    }

    @Test
    @DisplayName("직사각형 넓이 구하기")
    void calculate_rectangle_area() {
        Points points = new Points("(4,3)-(0,0)-(4,0)-(0,3)");
        Figure rectangle = FigureFactory.createFigure(points);
        assertThat(rectangle.calculateDistanceOrArea()).isEqualTo(12, offset(0.000009));
    }
}