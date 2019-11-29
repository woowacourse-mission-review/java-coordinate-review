package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Points {
    private static final String WHITE_SPACE = " ";
    private static final String EMPTY_SPACE ="";
    private static final String POINTS_BRACKET_PATTERN = "\\(|\\)";
    private static final String POINTS_DELIMITER = "-";
    private List<Point> points;

    public Points(String userInput) {
        userInput = userInput.replaceAll(WHITE_SPACE,EMPTY_SPACE);
        List<String> parsedUserInput = parse(userInput);
        this.points = parsedUserInput.stream()
                .map(Point::new)
                .collect(Collectors.toList());
    }

    private List<String> parse(String userInput) {
        userInput = userInput.replaceAll(POINTS_BRACKET_PATTERN,"");
        return Arrays.asList(userInput.split(POINTS_DELIMITER));
    }

    public Point getPointAt(int index) {
        return points.get(index);
    }
}
