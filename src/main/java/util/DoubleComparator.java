package util;

public class DoubleComparator {
    private static final double OFFSET = 0.001;

    public static boolean equals(double d1, double d2) {
        return Math.abs(d1 - d2) < OFFSET;
    }
}
