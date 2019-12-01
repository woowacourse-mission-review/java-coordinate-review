package domain;

import domain.exception.InvalidNumberOfPointsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShapeFactoryTest {
    private final Coordinate x1 = CoordinateFactory.get("10");
    private final Coordinate y1 = CoordinateFactory.get("10");
    private final Coordinate x2 = CoordinateFactory.get("22");
    private final Coordinate y2 = CoordinateFactory.get("10");
    private final Coordinate x3 = CoordinateFactory.get("22");
    private final Coordinate y3 = CoordinateFactory.get("18");
    private final Coordinate x4 = CoordinateFactory.get("10");
    private final Coordinate y4 = CoordinateFactory.get("18");

    private final Point p1 = new Point(x1, y1);
    private final Point p2 = new Point(x2, y2);
    private final Point p3 = new Point(x3, y3);
    private final Point p4 = new Point(x4, y4);
    private final Point p5 = new Point(x1, y4);

    @Test
    @DisplayName("점 두 개를 사용하여 선 객체를 생성한다.")
    void create_Line() {
        assertDoesNotThrow(() -> ShapeFactory.create(Arrays.asList(p1, p2)));
    }

    @Test
    @DisplayName("점 세 개를 사용하여 삼까형 객체를 생성한다.")
    void create_Triangle() {
        assertDoesNotThrow(() -> ShapeFactory.create(Arrays.asList(p1, p2, p3)));
    }

    @Test
    @DisplayName("점 네 개를 사용하여 사각형 객체를 생성한다.")
    void create_Rectangle() {
        assertDoesNotThrow(() -> ShapeFactory.create(Arrays.asList(p1, p2, p3, p4)));
    }

    @Test
    @DisplayName("유효하지 않는 점 개수로 domain.Shape 생성 시 예외가 발생한다.")
    void create_invalid_Shape() {
        assertThrows(InvalidNumberOfPointsException.class,
                () -> ShapeFactory.create(Arrays.asList(p1, p2, p3, p4, p5)));
    }
}
