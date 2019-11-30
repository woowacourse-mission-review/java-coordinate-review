package domain;

import exception.UnavailabeCoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {

    @Test
    @DisplayName("포인트 생성 테스트")
    void point_constructor_test() {
        Point point = new Point("1,2");
        assertThat(point.getxCoordinate()).isEqualTo(Coordinates.retrieveValue(1));
        assertThat(point.getyCoordinate()).isEqualTo(Coordinates.retrieveValue(2));
    }

    @Test
    @DisplayName("포인트 생성 실패 테스트, 24보다 큰수")
    void fail_point_constructor_test() {
        Exception exception = assertThrows(UnavailabeCoordinateException.class, () -> new Point("25, 1"));
        assertThat(exception.getMessage()).isEqualTo(UnavailabeCoordinateException.MESSAGE);
    }

    @Test
    @DisplayName("포인트 생성 실패 테스트, 0보다 작은수")
    void fail_point_constructor_test2() {
        Exception exception = assertThrows(UnavailabeCoordinateException.class, () -> new Point("23,-1"));
        assertThat(exception.getMessage()).isEqualTo(UnavailabeCoordinateException.MESSAGE);
    }

    @Test
    @DisplayName("점과 점 사이의 거리 구하기")
    void calculate_distance_of_points() {
        Point point1 = new Point("0,0");
        Point point2 = new Point("24,0");

        assertThat(point1.calculateDistance(point2)).isEqualTo(24);
    }

    @Test
    @DisplayName("점과 점 사이의 거리 구하기")
    void calculate_distance_of_points2() {
        Point point1 = new Point("0,0");
        Point point2 = new Point("6,11");

        assertThat(point1.calculateDistance(point2)).isEqualTo(Math.sqrt(157));
    }

    @Test
    @DisplayName("두 점이 같은 X좌표를 갖는지 확인하기")
    void same_x_coordinate_only() {
        Point point1 = new Point("0,5");
        Point point2 = new Point("0,7");

        assertThat(point1.doesHaveSameXCoordinateOnly(point2)).isTrue();
    }

    @Test
    @DisplayName("두 점이 같은 X좌표를 갖는지 확인하기")
    void same_x_coordinate_only2() {
        Point point1 = new Point("2,5");
        Point point2 = new Point("2,7");

        assertThat(point1.doesHaveSameXCoordinateOnly(point2)).isTrue();
    }

    @Test
    @DisplayName("두 점이 같은 Y좌표를 갖는지 확인하기")
    void same_y_coordinate_only() {
        Point point1 = new Point("1,5");
        Point point2 = new Point("2,5");

        assertThat(point1.doesHaveSameYCoordinateOnly(point2)).isTrue();
    }

    @Test
    @DisplayName("두 점이 같은 Y좌표를 갖는지 확인하기")
    void same_y_coordinate_only2() {
        Point point1 = new Point("3,7");
        Point point2 = new Point("2,7");

        assertThat(point1.doesHaveSameYCoordinateOnly(point2)).isTrue();
    }
}