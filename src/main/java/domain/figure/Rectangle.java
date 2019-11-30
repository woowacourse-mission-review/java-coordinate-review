package domain.figure;

import domain.Points;

public class Rectangle implements Figure {
    private Points points;

    public Rectangle(Points points) {
        checkIfRectangle(points);
        this.points = points;
    }

    private void checkIfRectangle(Points points) {
        points.isSpreadRectangly();
    }
}
