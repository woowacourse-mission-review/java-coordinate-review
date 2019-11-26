package coordinates.service;

import coordinates.domain.Points;
import coordinates.exception.IllegalPointsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateCalculatorService {

    private static final String POINTS_INPUT_REGEX
            = "(\\((\\s)*[0-9]+(\\s)*,(\\s)*[0-9]+(\\s)*\\))((\\s)*-(\\s)*(\\((\\s)*[0-9]+(\\s)*,(\\s)*[0-9]+(\\s)*\\))){0,3}";

    public Points parsePointsInput(final String pointsInput) {
        Pattern pattern = Pattern.compile(POINTS_INPUT_REGEX);
        Matcher matcher = pattern.matcher(pointsInput);

        if (matcher.matches()) {
            // TODO: 26/11/2019 create Points
            return new Points();
        }
        throw new IllegalPointsException();
    }
}
