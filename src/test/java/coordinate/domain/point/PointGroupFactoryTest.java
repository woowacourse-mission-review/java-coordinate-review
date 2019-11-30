package coordinate.domain.point;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static coordinate.domain.point.PointGroupFactory.NOT_VALID_INPUT_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointGroupFactoryTest {
    private final PointGroupFactory factory = new PointGroupFactory();

    @Test
    void 생성_정상입력_확인() {
        final PointGroup pointGroup1 = factory.create("(10,10)-(14,15)");
        final PointGroup pointGroup2 = factory.create("(10,10)-(14,15)-(11,19)");

        assertThat(pointGroup1.matchSize(2)).isTrue();
        assertThat(pointGroup2.matchSize(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "10,10)-(14,15)",
            "(10,10)(14,15)",
            "(10,10)-(14,15",
            "(10,10),(14,15)",
            "10,10-14,15",
            "[10,10]-[14,15]"
    })
    void 생성_잘못_입력_예외처리(final String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> factory.create(input));

        assertThat(exception.getMessage()).isEqualTo(NOT_VALID_INPUT_EXCEPTION_MESSAGE);
    }
}