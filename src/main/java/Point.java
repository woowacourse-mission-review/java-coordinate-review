public class Point {
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
}
