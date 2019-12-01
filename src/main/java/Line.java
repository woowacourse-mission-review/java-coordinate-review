public class Line {
    private final Point p1;
    private final Point p2;

    public Line(Point p1, Point p2) {
        validate(p1, p2);
        this.p1 = p1;
        this.p2 = p2;
    }

    private void validate(Point p1, Point p2) {
        if (p1.equals(p2)) {
            throw new InvalidLineException();
        }
    }

    public Double length() {
        Integer diffX = p1.minusX(p2);
        Integer diffY = p1.minusY(p2);

        return Math.sqrt(diffX * diffX +diffY * diffY);
    }
}
