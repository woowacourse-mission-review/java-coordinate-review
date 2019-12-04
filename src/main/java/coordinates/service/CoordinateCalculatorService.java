package coordinates.service;

import coordinates.domain.point.Point;
import coordinates.domain.point.Points;
import coordinates.exception.IllegalPointsException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CoordinateCalculatorService {

    private static final String POINTS_INPUT_REGEX
            = "(\\((\\s)*[0-9]+(\\s)*,(\\s)*[0-9]+(\\s)*\\))((\\s)*-(\\s)*(\\((\\s)*[0-9]+(\\s)*,(\\s)*[0-9]+(\\s)*\\))){1,3}";
    private static final String POINT_INPUT_REGEX = "\\(([0-9]+),([0-9]+)\\)";
    private static final Pattern POINTS_INPUT_PATTERN = Pattern.compile(POINTS_INPUT_REGEX);
    private static final Pattern POINT_INPUT_PATTERN = Pattern.compile(POINT_INPUT_REGEX);
    private static final String POINT_DELIMITER = "-";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    public Points parsePointsInput(String pointsInput) {
        Matcher matcher = POINTS_INPUT_PATTERN.matcher(pointsInput);

        if (matcher.matches()) {
            return parsePoints(pointsInput);
        }
        throw new IllegalPointsException();
    }

    private Points parsePoints(final String pointsInput) {
        String[] tokens = pointsInput.split(POINT_DELIMITER);

        List<Point> parsedPoints = Arrays.stream(tokens)
                .map(token -> token.replace(BLANK, EMPTY))
                .map(this::createPointFrom)
                .collect(Collectors.toList());
        return Points.from(parsedPoints);
    }

    private Point createPointFrom(String pointInput) {
        Matcher matcher = POINT_INPUT_PATTERN.matcher(pointInput);

        if (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));

            return Point.of(x, y);
        }
        throw new IllegalPointsException();
    }
}
