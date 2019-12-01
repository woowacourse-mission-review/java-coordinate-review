package domain;

public enum FigureType {
    LINE("선"),
    TRIANGLE("삼각형"),
    RECTANGLE("직사각형");

    private final String name;

    FigureType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
