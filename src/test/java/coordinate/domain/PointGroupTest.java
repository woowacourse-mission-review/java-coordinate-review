package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static coordinate.domain.PointGroup.DUPLICATED_POINT_EXCEPTION_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointGroupTest {

    @Test
    void 생성_정상입력_확인() {
        final PointGroup pointGroup1 = PointGroup.of(List.of(Point.of(10, 10), Point.of(10, 12)));
        final PointGroup pointGroup2 = PointGroup.of(List.of(Point.of(10, 10), Point.of(10, 11), Point.of(11, 12)));

        assertThat(pointGroup1.size()).isEqualTo(2);
        assertThat(pointGroup2.size()).isEqualTo(3);
    }

    @Test
    void 중복_Point_예외처리() {
        List<Point> points = List.of(Point.of(10, 10), Point.of(10, 10));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> PointGroup.of(points));

        assertThat(exception.getMessage()).isEqualTo(DUPLICATED_POINT_EXCEPTION_MESSAGE);
    }
}