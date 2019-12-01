package coordinatecalculator.domain.figure;

import coordinatecalculator.domain.result.Result;

public interface Figure {

    boolean contains(Point point);

    Result createResult();
}
