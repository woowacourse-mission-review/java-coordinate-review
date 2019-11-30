package domain.figure;

import domain.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    @DisplayName("사각형 넓이 구하기")
    void calculate_triangle_area() {
        Points points = new Points("(4,4)-(0,0)-(0,4)-(4,0)");
        Figure rectangle = FigureFactory.createFigure(points);
        assertThat(rectangle.calculateDistanceOrArea()).isEqualTo(16, offset(0.000009));
    }

}