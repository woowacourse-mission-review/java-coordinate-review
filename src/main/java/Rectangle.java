import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rectangle extends Shape{

    public Rectangle(List<Point> points) {
        super(points);
    }

    public Integer area() {
        Collections.sort(points);
        Line height = new Line(Arrays.asList(points.get(0), points.get(1)));
        Line width = new Line(Arrays.asList(points.get(0), points.get(2)));
        return (int) (height.length() * width.length());
    }
}
