package chapter2.exercises.e2_7;

import common.Function;
import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_7Test {

    @Test
    public void testPartialA() {
        Function<Integer, Function<Double, Double>> f = a -> b -> a * (1 + b / 100);
        Function<Double, Double> g = Exercise2_7.partialA(89, f);

        assertEquals(f.apply(89).apply(7.0), g.apply(7.0));
        assertEquals(f.apply(89).apply(0.0), g.apply(0.0));
        assertEquals(f.apply(89).apply(16.65), g.apply(16.65));
    }
}