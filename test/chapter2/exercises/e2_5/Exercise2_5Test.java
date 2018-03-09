package chapter2.exercises.e2_5;

import common.Function;
import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_5Test {

    @Test
    public void higherCompose() {
        int x = Exercise2_5.<Integer, Integer, Integer>higherCompose().apply(Exercise2_5.square).apply(Exercise2_5.triple).apply(2);
        assertEquals(36, x);
    }

    @Test
    public void higherAndThen2() {
        Function<Double, Integer> f = a -> (int)(a*3);
        Function<Long, Double> g = a-> a + 2.0;

        assertEquals(Integer.valueOf(9), f.apply(g.apply(1L)));
        assertEquals(Integer.valueOf(9), Exercise2_5.<Long,Double, Integer>higherCompose().apply(f).apply(g).apply(1L));
    }
}