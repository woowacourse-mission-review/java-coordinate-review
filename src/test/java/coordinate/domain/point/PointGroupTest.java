package coordinate.domain.point;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static coordinate.domain.point.PointGroup.DUPLICATED_POINT_EXCEPTION_MESSAGE;
import static coordinate.domain.point.PointGroup.EMPTY_EXCEPTION_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PointGroupTest {

    @Test
    void 생성_정상입력_확인() {
        final PointGroup pointGroup1 = PointGroup.of(List.of(Point.of(10, 10), Point.of(10, 12)));
        final PointGroup pointGroup2 = PointGroup.of(List.of(Point.of(10, 10), Point.of(10, 11), Point.of(11, 12)));

        assertTrue(pointGroup1.matchSize(2));
        assertTrue(pointGroup2.matchSize(3));
    }

    @Test
    void emptyException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> PointGroup.of(Collections.emptyList()));

        assertThat(exception.getMessage()).isEqualTo(EMPTY_EXCEPTION_MESSAGE);
    }

    @Test
    void matchSizeTest() {
        final PointGroup pointGroup = PointGroup.of(List.of(Point.of(10, 10)));

        assertTrue(pointGroup.matchSize(1));
    }

    @Test
    void x기준_정렬_확인() {
        final Point first = Point.of(10, 10);
        final Point second = Point.of(11, 11);
        final Point third = Point.of(12, 12);
        final PointGroup pointGroup = PointGroup.of(List.of(first, second, third));

        assertThat(pointGroup.get(0)).isEqualTo(first);
        assertThat(pointGroup.get(1)).isEqualTo(second);
        assertThat(pointGroup.get(2)).isEqualTo(third);
    }

    @Test
    void y기준_정렬_확인() {
        final Point second = Point.of(10, 12);
        final Point first = Point.of(10, 11);
        final Point third = Point.of(10, 13);
        final PointGroup pointGroup = PointGroup.of(List.of(first, second, third));

        assertThat(pointGroup.get(0)).isEqualTo(first);
        assertThat(pointGroup.get(1)).isEqualTo(second);
        assertThat(pointGroup.get(2)).isEqualTo(third);
    }


    @Test
    void 중복_Point_예외처리() {
        List<Point> points = List.of(Point.of(10, 10), Point.of(10, 10));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> PointGroup.of(points));

        assertThat(exception.getMessage()).isEqualTo(DUPLICATED_POINT_EXCEPTION_MESSAGE);
    }
}