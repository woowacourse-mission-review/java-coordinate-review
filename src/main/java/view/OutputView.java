package view;

import domain.graph.Graph;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printGraph(Graph graph) {
        System.out.println(graph);
        String x_AXIS_BARS = "   ----------------------------------------------------------";
        System.out.println(x_AXIS_BARS);
        String x_AXIS_NUMBERS = "  0   2   4   6   8  10  12  14  16  18  20  22  24";
        System.out.println(x_AXIS_NUMBERS);
        System.out.println(graph.getFinalStatement());
    }
}
