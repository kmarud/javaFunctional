package common;

import org.junit.Test;

import static org.junit.Assert.*;

public class TupleTest {
    @Test
    public void creationTest(){
        Tuple<Integer, Double> tuple = new Tuple<>(5,9.0);
        assertEquals(Integer.valueOf(5), tuple._1);
        assertEquals(9.0, tuple._2, 0.001);
    }
}