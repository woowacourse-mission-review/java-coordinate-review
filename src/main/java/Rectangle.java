import java.util.Collections;
import java.util.List;

public class Rectangle {
    private final List<Point> points;

    public Rectangle(List<Point> points) {
        Collections.sort(points);
        this.points = points;
    }

    public Integer area() {
        Line height = new Line(points.get(0), points.get(1));
        Line width = new Line(points.get(0), points.get(2));
        return (int) (height.length() * width.length());
    }
}
