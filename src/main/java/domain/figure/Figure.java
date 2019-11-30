package domain.figure;

import domain.graph.Graph;

public interface Figure {
    Graph drawGraph();

    double calculateDistanceOrArea();
}
