package coordinate.domain.figure;

public interface Figure {

    int size();

    double area();

    /**
     * 점의 개수(PointGroup)와 도형이 일치하는지 검사한다.
     */
    void validateSize(final int sizeOfFigure);

    String getName();
}
