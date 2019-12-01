import java.util.Objects;

public class Point implements Comparable<Point> {
    private final Coordinate x;
    private final Coordinate y;

    public Point(Coordinate x, Coordinate y) {
        this.x = x;
        this.y = y;
    }

    public Integer minusX(Point another) {
        return x.minus(another.x);
    }

    public Integer minusY(Point another) {
        return y.minus(another.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point another) {
        if (x.equals(another.x)) {
            return y.minus(another.y);
        }

        return x.minus(another.x);
    }
}
