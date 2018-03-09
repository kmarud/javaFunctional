package chapter2.exercises.e2_8;

import common.Function;
import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_8Test {

    @Test
    public void partialB() {
        Function<Integer, Function<Double, Double>> f = a -> b -> a * (1 + b / 100);
        Function<Integer, Double> g = Exercise2_8.partialB(16.65, f);

        assertEquals(f.apply(12).apply(16.65), g.apply(12));
        assertEquals(f.apply(0).apply(16.65), g.apply(0));
        assertEquals(f.apply(849).apply(16.65), g.apply(849));
    }
}