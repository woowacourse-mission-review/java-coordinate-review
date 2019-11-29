package domain;

import exception.UnavailabeCoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}