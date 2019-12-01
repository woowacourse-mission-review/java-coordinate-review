package domain;

public class Vector {
    private final int x;
    private final int y;

    private Vector(Point p1, Point p2) {
        this.x = p2.getX() - p1.getX();
        this.y = p2.getY() - p1.getY();
    }

    public static Vector of(Point p1, Point p2) {
        return new Vector(p1, p2);
    }

    public int innerProduct(Vector another) {
        return x * another.getX() + y * another.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
