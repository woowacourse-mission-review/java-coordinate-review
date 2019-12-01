package util;

import domain.Coordinate;
import domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsolePointsGenerator {
    private static final String POINT_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)";

    public static List<Point> generate(List<String> consoleInputs) {
        List<Point> points = new ArrayList<>();
        for (String input : consoleInputs) {
            Matcher matcher = Pattern.compile(POINT_REGEX).matcher(input);
            matcher.matches();
            Coordinate x = new Coordinate(matcher.group(1));
            Coordinate y = new Coordinate(matcher.group(3));
            points.add(new Point(x, y));
        }
        return points;
    }
}
