package chapter2.exercises.e2_3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_3Test {
    @Test
    public void addTest(){
        int a = Exercise2_3.add.apply(4).apply(6);
        assertEquals(10, a);
    }

}