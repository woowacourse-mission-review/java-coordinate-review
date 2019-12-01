import java.util.List;

public class Line extends Shape {

    public Line(List<Point> points) {
        super(points);
    }

    public Double length() {
        Point p1 = points.get(0);
        Point p2 = points.get(1);

        Integer diffX = p1.minusX(p2);
        Integer diffY = p1.minusY(p2);

        return Math.sqrt(diffX * diffX +diffY * diffY);
    }
}
