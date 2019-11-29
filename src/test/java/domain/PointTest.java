package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {

    @Test
    @DisplayName("포인트 생성 테스트")
    void point_constructor_test() {
        Point point = new Point(1, 2);
        assertThat(point.getxCoordinate()).isEqualTo(Coordinates.retrieveValue(1));
        assertThat(point.getyCoordinate()).isEqualTo(Coordinates.retrieveValue(2));
    }

}