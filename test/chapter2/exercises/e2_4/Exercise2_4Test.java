package chapter2.exercises.e2_4;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_4Test {

    @Test
    public void test(){
        int x = Exercise2_4.compose.apply(Exercise2_4.square).apply(Exercise2_4.triple).apply(2);
        assertEquals(36, x);
    }

}