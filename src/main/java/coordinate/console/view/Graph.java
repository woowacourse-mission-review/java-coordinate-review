package coordinate.console.view;

import coordinate.domain.point.Coordinate;
import coordinate.domain.point.Point;
import coordinate.domain.point.PointGroup;

public class Graph {
    private boolean[][] coordinates;

    public Graph(PointGroup pointGroup) {
        this.coordinates = new boolean[Coordinate.MAX_VALUE][Coordinate.MAX_VALUE];
        drawPoints(pointGroup);
    }

    private void drawPoints(PointGroup pointGroup) {
        for (int i = 0; i < pointGroup.size(); i++) {
            final Point point = pointGroup.get(i);
            coordinates[point.getX()][point.getY()] = true;
        }
    }

    public boolean[][] getCoordinates() {
        return coordinates.clone();
    }
}
