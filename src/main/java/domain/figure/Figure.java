package domain.figure;

import domain.Graph;

public interface Figure {
    Graph drawGraph();

    double calculateDistanceOrArea();
}
