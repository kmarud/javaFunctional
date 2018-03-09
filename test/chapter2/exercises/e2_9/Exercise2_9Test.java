package chapter2.exercises.e2_9;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_9Test {

    @Test
    public void func() {
        assertEquals("jeden, 2, 3.0, c", Exercise2_9.func().apply("jeden").apply(2).apply(3.0).apply('c'));
    }
}