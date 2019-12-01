package view;

import domain.Shape;

public class OutputView {

    public static void printResult(Shape shape) {
        System.out.println("결과는 " + shape.area());
    }
}
