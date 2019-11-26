package coordinates.domain;

import java.util.List;

public class Points {

    private final List<Point> innerPoints;

    private Points(final List<Point> innerPoints) {
        this.innerPoints = innerPoints;
    }

    public static Points from(final List<Point> innerPoints) {
        return new Points(innerPoints);
    }

    public int size() {
        return innerPoints.size();
    }

    public Point get(final int index) {
        return innerPoints.get(index);
    }
}
