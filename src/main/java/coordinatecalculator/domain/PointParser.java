package coordinatecalculator.domain;

import coordinatecalculator.domain.figure.Point;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PointParser {

    private static final Pattern ENTIRE_POINT_INPUT_PATTERN = Pattern.compile("^(\\([0-9]+,[0-9]+\\)-)*(\\([0-9]+,[0-9]+\\))$");

    private static final String POINTS_DELIMITER = "-";
    private static final String COORDINATES_DELIMITER = ",";


    public List<Point> parse(final String inputRawPoints) {
        validateInputFormat(inputRawPoints);
        return parsePoints(inputRawPoints);
    }

    private void validateInputFormat(final String inputRawPoints) {
        Matcher entireMatcher = ENTIRE_POINT_INPUT_PATTERN.matcher(inputRawPoints);

        if (!entireMatcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Point> parsePoints(final String inputRawPoints) {
        List<String> inputPoints = parseInputPoint(inputRawPoints);

        return inputPoints.stream()
                .map(this::parseCoordinates)
                .collect(Collectors.toList());
    }

    private List<String> parseInputPoint(final String inputRawPoints) {
        return Arrays.stream(inputRawPoints.split(POINTS_DELIMITER))
                .map(point -> point.substring(1, point.length() - 1))
                .collect(Collectors.toList());
    }

    private Point parseCoordinates(final String s) {
        String[] points2 = s.split(COORDINATES_DELIMITER);
        return Point.of(Integer.parseInt(points2[0]), Integer.parseInt(points2[1]));
    }
}
