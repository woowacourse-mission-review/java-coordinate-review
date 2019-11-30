package domain.graph;

import domain.Coordinates;
import domain.Point;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Graph {
    private String finalStatement;
    private List<Row> rows;

    public Graph(String finalStatement, List<Point> points) {
        this.finalStatement = finalStatement;
        this.rows = IntStream.rangeClosed(Coordinates.NUMBER_LOWER_BOUNDARY, Coordinates.NUMBER_UPPER_BOUNDARY)
                .mapToObj(index -> new Row())
                .collect(Collectors.toList());

        points.forEach(point -> rows.get(point.getyCoordinate().getValue()).setPosition(point.getxCoordinate().getValue()));
    }

    public String getFinalStatement() {
        return finalStatement;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = Coordinates.NUMBER_UPPER_BOUNDARY; i > 0; i--) {
            stringBuilder.append(String.format("%3s", i +"|")).append(rows.get(i).toString()).append("\n");
        }
        stringBuilder.append(String.format("%3s", 0 + "|")).append(rows.get(0).toString());

        return stringBuilder.toString();
    }
}
