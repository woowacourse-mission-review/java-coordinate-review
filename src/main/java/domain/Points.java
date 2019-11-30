package domain;

import exception.DuplicatePointsException;
import exception.RectangleException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Points {
    private static final String WHITE_SPACE = " ";
    private static final String EMPTY_SPACE ="";
    private static final String POINTS_BRACKET_PATTERN = "\\(|\\)";
    private static final String POINTS_DELIMITER = "-";
    private static final int RECTANGLE_POINT_QUANTITY_REQUIREMENT = 2;
    private List<Point> points;

    public Points(String userInput) {
        userInput = userInput.replaceAll(WHITE_SPACE, EMPTY_SPACE);
        List<String> parsedUserInput = parse(userInput);
        checkDuplicates(parsedUserInput);
        this.points = parsedUserInput.stream()
                .map(Point::new)
                .collect(Collectors.toList());
    }

    private void checkDuplicates(List<String> parsedUserInput) {
        Set<String> uniqueUserInput = new HashSet<>(parsedUserInput);
        if (uniqueUserInput.size() != parsedUserInput.size()) {
            throw new DuplicatePointsException();
        }
    }

    private List<String> parse(String userInput) {
        userInput = userInput.replaceAll(POINTS_BRACKET_PATTERN,"");
        return Arrays.asList(userInput.split(POINTS_DELIMITER));
    }

    public Point getPointAt(int index) {
        return points.get(index);
    }

    public boolean isRightKey(int numberOfPoints) {
        return numberOfPoints == points.size();
    }

    public void isSpreadRectangly() {
        Set<Coordinate> xCoordinates = points.stream()
                .map(Point::getxCoordinate)
                .collect(Collectors.toSet());

        Set<Coordinate> yCoordinates = points.stream()
                .map(Point::getyCoordinate)
                .collect(Collectors.toSet());

        if (xCoordinates.size() != RECTANGLE_POINT_QUANTITY_REQUIREMENT || yCoordinates.size() != RECTANGLE_POINT_QUANTITY_REQUIREMENT) {
            throw new RectangleException();
        }
    }
}
