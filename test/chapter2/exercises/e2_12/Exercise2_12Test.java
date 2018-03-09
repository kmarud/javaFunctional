package chapter2.exercises.e2_12;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_12Test {

    @Test
    public void factorialMethodTest() {
        assertEquals(24, Exercise2_12.factorialMethod(4));
    }

    @Test
    public void factorial() {
        assertEquals(24, (int)Exercise2_12.factorial.apply(4));
    }
}