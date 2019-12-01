package coordinatecalculator.domain.coordinates.exception;

public class InvalidCoordinateException extends RuntimeException {

    public InvalidCoordinateException(final String message) {
        super(message);
    }
}
