package coordinatecalculator.view;

import coordinatecalculator.domain.result.Result;

public interface OutputView {

    void printResult(Result result);

    void printErrorMessage(Exception e);
}
