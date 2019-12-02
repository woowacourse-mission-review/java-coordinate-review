package coordinatecalculator.service;

import coordinatecalculator.domain.PointParser;
import coordinatecalculator.domain.figure.Figure;
import coordinatecalculator.domain.figure.FigureFactory;
import coordinatecalculator.domain.figure.Point;
import coordinatecalculator.domain.result.Result;

import java.util.List;

public class CoordinateCalculatorService {

    private final FigureFactory figureFactory = new FigureFactory();
    private final PointParser pointParser = new PointParser();

    public Result calculate(final String rawInputPoints) {
        List<Point> points = pointParser.parse(rawInputPoints);
        Figure figure = figureFactory.createFigure(points);
        return figure.createResult();
    }
}
