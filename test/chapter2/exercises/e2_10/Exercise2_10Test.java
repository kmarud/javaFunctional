package chapter2.exercises.e2_10;

import common.Function;
import common.Tuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_10Test {

    @Test
    public void testCurry() {
        Function<Tuple<Integer, Double>, Double> f = x -> x._1 * (1 + x._2 / 100);
        Function<Integer, Function<Double, Double>> g = Exercise2_10.curry(f);

        assertEquals(f.apply(new Tuple<>(89, 7.0)), g.apply(89).apply(7.0));
        assertEquals(f.apply(new Tuple<>(27, 0.0)), g.apply(27).apply(0.0));
        assertEquals(f.apply(new Tuple<>(1623, 16.65)), g.apply(1623).apply(16.65));
    }
}