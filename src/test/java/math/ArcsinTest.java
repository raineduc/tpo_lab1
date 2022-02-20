package math;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ArcsinTest {
    private static final double threshold = 0.001;

    @Test
    void nan() {
        assertEquals(Double.NaN, Arcsin.calc(Double.NaN));
    }

    @ParameterizedTest
    @ValueSource(doubles = { 1, 1.5, 5, Double.POSITIVE_INFINITY })
    void toRightOfAreaOfConvergence(double x) {
        assertEquals(Double.NaN, Arcsin.calc(x));
    }

    @ParameterizedTest
    @ValueSource(doubles = { -1, -1.5, -5, Double.NEGATIVE_INFINITY })
    void toLeftOfAreaOfConvergence(double x) {
        assertEquals(Double.NaN, Arcsin.calc(x));
    }

    @ParameterizedTest
    @ValueSource(doubles = { -1 + 0.01, -0.75, -0.5, -0.25, 0, 0.25, 0.5, 0.75, 1 - 0.01, -0.666, 0.666, -0.001, 0.001 })
    void valuesInAreaOfConvergence(double x) {
        assertEquals(Math.asin(x), Arcsin.calc(x), threshold);
    }
}
