import java.util.List;

public class Triangle {
    private final List<Point> points;

    public Triangle(List<Point> points) {
        this.points = points;
    }

    public Double area() {
        Line line1 = new Line(points.get(0), points.get(1));
        Line line2 = new Line(points.get(0), points.get(2));
        Line line3 = new Line(points.get(1), points.get(2));
        return getTriangleAreaUsingHeronFormula(line1.length(), line2.length(), line3.length());
    }

    public static double getTriangleAreaUsingHeronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
