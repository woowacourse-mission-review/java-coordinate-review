package domain.figure;

import domain.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    @DisplayName("삼각형 넓이 구하기")
    void calculate_triangle_area() {
        Points points = new Points("(0,0)-(2,0)-(2,2)");
        Figure triangle = FigureFactory.createFigure(points);
        assertThat(triangle.calculateDistanceOrArea()).isEqualTo(2, offset(0.000009));
    }

    @Test
    @DisplayName("삼각형 넓이 구하기")
    void calculate_triangle_area2() {
        Points points = new Points("(0,0)-(16,0)-(16,16)");
        Figure triangle = FigureFactory.createFigure(points);
        assertThat(triangle.calculateDistanceOrArea()).isEqualTo(128, offset(0.000009));
    }
}