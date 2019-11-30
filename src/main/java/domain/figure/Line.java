package domain.figure;

import domain.Points;

public class Line implements Figure {
    private Points points;

    public Line(Points points) {
        this.points = points;
    }
}
