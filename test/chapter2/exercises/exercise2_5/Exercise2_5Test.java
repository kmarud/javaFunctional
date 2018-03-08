package chapter2.exercises.exercise2_5;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_5Test {

    @Test
    public void higherCompose() {
        int x = Exercise2_5.<Integer, Integer, Integer>higherCompose().apply(Exercise2_5.square).apply(Exercise2_5.triple).apply(2);
        assertEquals(36, x);
    }
}