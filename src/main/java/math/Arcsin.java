package math;

import java.util.stream.IntStream;

public class Arcsin {
    private static int iterations = 33;

    private static long factorial(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (x, y) -> x * y);
    }

    public static double calc(double x) {
        if (Math.abs(x) >= 1) return Double.NaN;
        double result = 0;
        for (int i = 0; i <= iterations; i++) {
            result += factorial(2 * i) / Math.pow(4, i) / Math.pow(factorial(i), 2) / (2 * i + 1) * Math.pow(x, 2 * i + 1);
        }
        return result;
    }
}
