package chapter2.exercises.e2_6;

import common.Function;
import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_6Test {

    @Test
    public void higherAndThen() {
        int x = Exercise2_6.<Integer, Integer, Integer>higherAndThen().apply(Exercise2_6.triple).apply(Exercise2_6.square).apply(2);
        assertEquals(36, x);
    }

    @Test
    public void higherAndThen2() {
        Function<Double, Integer> f = a -> (int)(a*3);
        Function<Long, Double> g = a-> a + 2.0;

        assertEquals(Integer.valueOf(9), f.apply(g.apply(1L)));
        assertEquals(Integer.valueOf(9), Exercise2_6.<Long,Double, Integer>higherAndThen().apply(g).apply(f).apply(1L));
    }
}