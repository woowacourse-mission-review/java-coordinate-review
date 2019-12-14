package coordinate.domain.point;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PointGroupFactory {
    static final String NOT_VALID_INPUT_EXCEPTION_MESSAGE = "유효한 입력이 아닙니다. ex) (10,10)-(13,10)-(20,8)";
    private static final String REGEX = "(\\([0-9]{1,2},[0-9]{1,2}\\)-)+\\([0-9]{1,2},[0-9]{1,2}\\)";
    private static final String DELIMITER_POINT = "-";
    private static final String DELIMITER_COORDINATE = ",";
    private static final Pattern VALID_INPUT_PATTERN = Pattern.compile(REGEX);

    public PointGroup create(final String inputPoints) {
        validateInput(inputPoints);

        // 1,2 에서 ,제거 후 Point 생성
        final List<Point> points = Stream.of(inputPoints.split(DELIMITER_POINT))
                .map(s -> s.substring(1, s.length() - 1)) // (1,2) 에서 () 제거
                .map(this::toPoint)
                .collect(Collectors.toList());

        return PointGroup.of(points);
    }

    private Point toPoint(final String point) {
        int index = point.indexOf(DELIMITER_COORDINATE);
        int x = Integer.parseInt(point.substring(0, index));
        int y = Integer.parseInt(point.substring(index + 1));
        return Point.of(x, y);
    }

    private void validateInput(final String inputPoints) {
        final Matcher matcher = VALID_INPUT_PATTERN.matcher(inputPoints);
        if (isNotMatch(matcher)) {
            throw new IllegalArgumentException(NOT_VALID_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotMatch(final Matcher matcher) {
        return !matcher.matches();
    }
}
